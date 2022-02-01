package cooperation.qzone.contentbox;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import cooperation.qzone.contentbox.model.MQButtonCell;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.MQUserClientShowInfo;
import cooperation.qzone.contentbox.model.MQUserPersonalData;
import cooperation.qzone.contentbox.model.MQUserPersonalProfile;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;
import cooperation.vip.VipReporterManager;
import cooperation.vip.vipcomponent.VipModule;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgPhotoView
  extends BaseMsgView
{
  private static final int AVATAR_GAP = ViewUtils.b(36.0F);
  private static final int MSG_UPDATE_AVATAR = 10001;
  private static final String TAG = "MsgPhotoView";
  public static final int TEXT_COLOR = -7500397;
  View.OnClickListener listener = new MsgPhotoView.1(this);
  private LinearLayout mAvatarContainer;
  private ImageView mAvatarImage;
  private FrameLayout mAvatarListLayout;
  private AnyScaleTypeImageView mBackgroundImage;
  private RelativeLayout mCommentContainer;
  private ImageView mCommentIcon;
  private TextView mCommentNum;
  private TextView mDesc1;
  private TextView mDesc2;
  private TextView mDesc3;
  private TextView mDesc4;
  private TextView mDesc5;
  private TextView mDesc6;
  View.OnClickListener mIconListener = new MsgPhotoView.3(this);
  private ImageView mImageShadow;
  private boolean mIsRepeat = false;
  private LinearLayout mLikeCommentContainer;
  private RelativeLayout mLikeContainer;
  private ImageView mLikeIcon;
  private TextView mLikeNum;
  private TextView mNickNameView;
  private ImageView mQQUnionVipIcon;
  private LinearLayout mQcircleContainer;
  private TextView mQcircleDes;
  private TextView mQcircleLikeCount;
  private TextView mQcirclePushCount;
  private ImageView mQqshareIcon;
  private TextView mQqshareText;
  private ImageView mQzoneshareIcon;
  private TextView mQzoneshareText;
  private LinearLayout mShareContainer;
  private RelativeLayout mShareQQView;
  private RelativeLayout mShareQzoneView;
  private ImageView mVideoIcon;
  private ImageView mVipLoverYellowIcon;
  private ImageView mVipYellowIcon;
  private MsgOnClickListener msgOnClickListener;
  
  public MsgPhotoView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MsgPhotoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MsgPhotoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public static String bigNumberFormatTranfer(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append("W");
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append("W");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append("W");
    return ((StringBuilder)localObject).toString();
  }
  
  private ArrayList<String> convert(ArrayList<MQPhotoCell> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        MQPhotoCell localMQPhotoCell = (MQPhotoCell)paramArrayList.get(i);
        if ((localMQPhotoCell != null) && (!TextUtils.isEmpty(localMQPhotoCell.coverUrl))) {
          localArrayList.add(localMQPhotoCell.coverUrl);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mUiHandler = new BaseMsgView.MyHandler(this);
    LayoutInflater.from(this.mContext).inflate(2080636935, this);
    this.mAvatarContainer = ((LinearLayout)findViewById(2080571406));
    this.mAvatarImage = ((ImageView)findViewById(2080571397));
    this.mNickNameView = ((TextView)findViewById(2080571483));
    this.mBackgroundImage = ((AnyScaleTypeImageView)findViewById(2080571411));
    this.mBackgroundImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.viewPager = ((QzoneMsgViewPager)findViewById(2080571539));
    initViewPager();
    this.mDesc1 = ((TextView)findViewById(2080571424));
    this.mDesc2 = ((TextView)findViewById(2080571425));
    this.mDesc3 = ((TextView)findViewById(2080571426));
    this.mDesc4 = ((TextView)findViewById(2080571427));
    this.mDesc5 = ((TextView)findViewById(2080571428));
    this.mDesc6 = ((TextView)findViewById(2080571429));
    this.mAvatarListLayout = ((FrameLayout)findViewById(2080571403));
    this.mLikeCommentContainer = ((LinearLayout)findViewById(2080571463));
    this.mLikeContainer = ((RelativeLayout)findViewById(2080571464));
    this.mCommentContainer = ((RelativeLayout)findViewById(2080571419));
    this.mLikeIcon = ((ImageView)findViewById(2080571465));
    this.mLikeNum = ((TextView)findViewById(2080571466));
    this.mCommentIcon = ((ImageView)findViewById(2080571420));
    this.mCommentNum = ((TextView)findViewById(2080571421));
    this.mShareContainer = ((LinearLayout)findViewById(2080571509));
    this.mShareQQView = ((RelativeLayout)findViewById(2080571490));
    this.mShareQzoneView = ((RelativeLayout)findViewById(2080571502));
    this.mQqshareIcon = ((ImageView)findViewById(2080571491));
    this.mQzoneshareIcon = ((ImageView)findViewById(2080571503));
    this.mQqshareText = ((TextView)findViewById(2080571492));
    this.mQzoneshareText = ((TextView)findViewById(2080571504));
    this.mLikeContainer.setOnClickListener(this.listener);
    this.mCommentContainer.setOnClickListener(this.listener);
    this.mShareQQView.setOnClickListener(this.listener);
    this.mShareQzoneView.setOnClickListener(this.listener);
    this.mImageShadow = ((ImageView)findViewById(2080571498));
    this.mVideoIcon = ((ImageView)findViewById(2080571538));
    this.mQcircleDes = ((TextView)findViewById(2080571486));
    this.mQcircleContainer = ((LinearLayout)findViewById(2080571489));
    this.mQcircleLikeCount = ((TextView)findViewById(2080571487));
    this.mQcirclePushCount = ((TextView)findViewById(2080571488));
    this.mQQUnionVipIcon = ((ImageView)findViewById(2080571459));
    this.mVipYellowIcon = ((ImageView)findViewById(2080571460));
    this.mVipLoverYellowIcon = ((ImageView)findViewById(2080571458));
    this.mQQUnionVipIcon.setOnClickListener(this.mIconListener);
    this.mVipYellowIcon.setOnClickListener(this.mIconListener);
    this.mVipLoverYellowIcon.setOnClickListener(this.mIconListener);
    setOnClickListener(this.listener);
  }
  
  private void showLoverVipIcon(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png", (URLDrawable.URLDrawableOptions)localObject);
    if (localObject != null)
    {
      this.mVipLoverYellowIcon.setImageDrawable((Drawable)localObject);
      this.mVipLoverYellowIcon.setVisibility(0);
      if (!this.mIsRepeat) {
        VipReporterManager.a(13, 1);
      }
    }
  }
  
  private void showPersonalVipInfo()
  {
    if ((this.mData != null) && (this.mData.mqUserPersonalData != null) && (this.mData.mqUserPersonalData.mUserPersonalProfileMap != null))
    {
      MQUserPersonalProfile localMQUserPersonalProfile = (MQUserPersonalProfile)this.mData.mqUserPersonalData.mUserPersonalProfileMap.get(this.mData.user_avatar);
      if (localMQUserPersonalProfile == null)
      {
        QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo userPersonalProfile = null");
        return;
      }
      if (QZLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MsgVip showPersonalVipInfo isRepeat = ");
        localStringBuilder.append(this.mIsRepeat);
        localStringBuilder.append("\n data = ");
        localStringBuilder.append(this.mData.mqUserPersonalData.convertToJson());
        QZLog.i("MsgPhotoView", 2, localStringBuilder.toString());
      }
      if ((localMQUserPersonalProfile.userClientShowInfo != null) && (localMQUserPersonalProfile.userClientShowInfo.iVip != 0) && (localMQUserPersonalProfile.userClientShowInfo.iLevel != 0)) {
        showQQUnionVipIcon(localMQUserPersonalProfile.userClientShowInfo);
      } else {
        showVipIcon(localMQUserPersonalProfile.vipLevel, localMQUserPersonalProfile.vip, localMQUserPersonalProfile.isAnnualVip);
      }
      int i = localMQUserPersonalProfile.isLoversVip;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      showLoverVipIcon(bool);
      return;
    }
    QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo vip data = null");
  }
  
  private void showQQUnionVipIcon(MQUserClientShowInfo paramMQUserClientShowInfo)
  {
    if ((paramMQUserClientShowInfo != null) && (!TextUtils.isEmpty(paramMQUserClientShowInfo.unionVipUrl)) && (paramMQUserClientShowInfo.unionIconWidth != 0))
    {
      if (paramMQUserClientShowInfo.unionIconHeight == 0) {
        return;
      }
      this.mQQUnionVipIcon.setVisibility(0);
      this.mVipYellowIcon.setVisibility(8);
      this.mVipLoverYellowIcon.setVisibility(8);
      if ((paramMQUserClientShowInfo.unionIconWidth > 0) && (paramMQUserClientShowInfo.unionIconHeight > 0))
      {
        localObject = this.mQQUnionVipIcon.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = ViewUtils.b(paramMQUserClientShowInfo.unionIconWidth / 2.0F);
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.b(paramMQUserClientShowInfo.unionIconHeight / 2.0F);
        this.mQQUnionVipIcon.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramMQUserClientShowInfo = paramMQUserClientShowInfo.unionVipUrl;
      Object localObject = new ZipAnimationDrawable();
      ((ZipAnimationDrawable)localObject).setAnimationRes(paramMQUserClientShowInfo, 10);
      ((ZipAnimationDrawable)localObject).setScale(ViewUtils.a() / 720.0F);
      ((ZipAnimationDrawable)localObject).setRepeatAnimation(true);
      ((ZipAnimationDrawable)localObject).clearFirstFrame();
      ((ZipAnimationDrawable)localObject).start();
      this.mQQUnionVipIcon.setImageDrawable((Drawable)localObject);
      if (!this.mIsRepeat) {
        VipReporterManager.a(12, 1);
      }
    }
  }
  
  private void showVipIcon(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 != 0) && (paramInt1 != 0))
    {
      Object localObject1 = new MsgPhotoView.WeakVipResourcesListener(this.mUiHandler, this.mVipLoverYellowIcon, paramInt2, this.mIsRepeat);
      Object localObject2 = VipModule.a();
      boolean bool;
      if (paramInt3 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localObject1 = ((VipModule)localObject2).a(paramInt1, paramInt2, bool, false, "", 8, (VipResourcesListener)localObject1);
      if (localObject1 != null)
      {
        localObject2 = this.mVipYellowIcon;
        if (paramInt2 == 2) {
          bool = true;
        } else {
          bool = false;
        }
        ((ImageView)localObject2).setTag(Boolean.valueOf(bool));
        this.mVipYellowIcon.setImageDrawable((Drawable)localObject1);
        this.mVipYellowIcon.setVisibility(0);
        if (!this.mIsRepeat)
        {
          if (paramInt2 == 2) {
            paramInt1 = 11;
          } else {
            paramInt1 = 10;
          }
          VipReporterManager.a(paramInt1, 1);
        }
      }
      return;
    }
    this.mVipYellowIcon.setVisibility(8);
  }
  
  protected boolean doHandleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10001)
    {
      paramMessage = (Drawable)paramMessage.obj;
      this.mAvatarImage.setImageDrawable(paramMessage);
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeCallbacksAndMessages(null);
      this.mUiHandler = null;
    }
  }
  
  public void setData(boolean paramBoolean1, MQMsg paramMQMsg, boolean paramBoolean2)
  {
    this.mIsRepeat = paramBoolean1;
    if (paramMQMsg == null) {
      return;
    }
    this.mData = paramMQMsg;
    if ((!TextUtils.isEmpty(paramMQMsg.user_avatar)) && (!TextUtils.isEmpty(paramMQMsg.user_nick)))
    {
      this.mAvatarContainer.setVisibility(0);
      ThreadManager.getSubThreadHandler().post(new MsgPhotoView.2(this, paramMQMsg));
      this.mNickNameView.setText(paramMQMsg.user_nick);
    }
    Object localObject1 = paramMQMsg.msgBody;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((MQMsgBody)localObject1).photolist != null))
    {
      if (((MQMsgBody)localObject1).photolist.size() > 1)
      {
        if ((paramMQMsg.msgType == 9) && (!TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          i = ((MQMsgBody)localObject1).photolist.size();
        } else {
          i = 0;
        }
        if ((((MQMsgBody)localObject1).photolist != null) && (((MQMsgBody)localObject1).photolist.size() > 9)) {
          if ((paramMQMsg.msgType == 9) && (!TextUtils.isEmpty(paramMQMsg.eventTitle))) {
            ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 3));
          } else {
            ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 9));
          }
        }
        this.viewPager.setVisibility(0);
        localObject2 = convert(((MQMsgBody)localObject1).photolist);
        this.pagerAdapter = new QzoneMsgPagerAdapter(this.mContext, (ArrayList)localObject2);
        this.viewPager.setAdapter(this.pagerAdapter);
        break label402;
      }
      if (((MQMsgBody)localObject1).photolist.size() == 1)
      {
        localObject2 = (MQPhotoCell)((MQMsgBody)localObject1).photolist.get(0);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((MQPhotoCell)localObject2).coverUrl)))
        {
          this.mBackgroundImage.setVisibility(0);
          if (((MQPhotoCell)localObject2).type != 2)
          {
            localObject2 = getUrlDrawable(((MQPhotoCell)localObject2).coverUrl);
            this.mBackgroundImage.setImageDrawable((Drawable)localObject2);
          }
          else
          {
            localObject3 = getApngDrawable();
            if (localObject3 != null)
            {
              this.mBackgroundImage.setImageDrawable((Drawable)localObject3);
            }
            else
            {
              localObject2 = getUrlDrawable(((MQPhotoCell)localObject2).coverUrl);
              this.mBackgroundImage.setImageDrawable((Drawable)localObject2);
            }
          }
        }
      }
    }
    int i = 0;
    label402:
    int j;
    if (localObject1 != null) {
      if (paramMQMsg.msgType == 12)
      {
        if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
        {
          this.mQcircleDes.setText(((MQMsgBody)localObject1).content);
          this.mQcircleDes.setVisibility(0);
        }
        if ((paramMQMsg.msgInteractData != null) && (paramMQMsg.msgInteractData.likeCell != null))
        {
          this.mQcircleContainer.setVisibility(0);
          this.mQcirclePushCount.setText(bigNumberFormatTranfer(paramMQMsg.msgInteractData.pushCount));
          this.mQcircleLikeCount.setText(bigNumberFormatTranfer(paramMQMsg.msgInteractData.likeCell.totalLike));
        }
        this.mImageShadow.setVisibility(0);
        findViewById(2080571501).setVisibility(8);
        findViewById(2080571532).setVisibility(8);
        this.mDesc4.setVisibility(8);
        this.mDesc5.setVisibility(8);
        this.mDesc6.setVisibility(8);
      }
      else
      {
        j = ((MQMsgBody)localObject1).mediaType;
        if (j == 1)
        {
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
          {
            this.mDesc3.setVisibility(0);
            this.mDesc3.setText(((MQMsgBody)localObject1).content);
            this.mImageShadow.setVisibility(8);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).title))
          {
            this.mDesc2.setVisibility(0);
            this.mDesc2.setText(((MQMsgBody)localObject1).title);
          }
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
          {
            this.mDesc1.setVisibility(0);
            this.mDesc1.setText(((MQMsgBody)localObject1).content);
          }
          if ((TextUtils.isEmpty(((MQMsgBody)localObject1).title)) && (TextUtils.isEmpty(((MQMsgBody)localObject1).content))) {
            this.mImageShadow.setVisibility(8);
          }
        }
        if (j == 3) {
          this.mVideoIcon.setVisibility(0);
        }
        if ((paramMQMsg.msgType == 9) && (!TextUtils.isEmpty(paramMQMsg.eventTitle)))
        {
          this.mDesc4.setVisibility(0);
          this.mDesc4.setText(paramMQMsg.eventTitle);
          this.mDesc5.setVisibility(0);
          localObject2 = this.mDesc5;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("摄于");
          ((StringBuilder)localObject3).append(paramMQMsg.capTime);
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          findViewById(2080571501).setVisibility(0);
          findViewById(2080571532).setVisibility(0);
          if (paramBoolean2)
          {
            ((ImageView)findViewById(2080571533)).setImageResource(2130848727);
            ((TextView)findViewById(2080571534)).setTextColor(-7500397);
          }
          if (((MQMsgBody)localObject1).photolist != null)
          {
            this.mDesc6.setVisibility(0);
            localObject2 = this.mDesc6;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(" ");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append("张照片 ∙ 上传前仅自己可见");
            ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          }
        }
        else if (paramMQMsg.msgType == 11)
        {
          if (!TextUtils.isEmpty(paramMQMsg.msgBody.coverPicUrl))
          {
            localObject2 = (ImageView)findViewById(2080571501);
            ((ImageView)localObject2).setVisibility(0);
            ((ImageView)localObject2).setImageDrawable(getUrlDrawable(paramMQMsg.msgBody.coverPicUrl));
          }
          this.mDesc1.setVisibility(8);
          this.mDesc6.setVisibility(0);
          this.mDesc6.setText(paramMQMsg.msgBody.content);
        }
        else
        {
          findViewById(2080571501).setVisibility(8);
          findViewById(2080571532).setVisibility(8);
          this.mDesc4.setVisibility(8);
          this.mDesc5.setVisibility(8);
          this.mDesc6.setVisibility(8);
        }
      }
    }
    if ((localObject1 != null) && (((MQMsgBody)localObject1).vecUserAvatar != null) && (((MQMsgBody)localObject1).vecUserAvatar.size() > 0))
    {
      this.mAvatarListLayout.setVisibility(0);
      this.mAvatarListLayout.removeAllViews();
      i = 5;
      if (5 >= ((MQMsgBody)localObject1).vecUserAvatar.size()) {
        i = ((MQMsgBody)localObject1).vecUserAvatar.size();
      }
      j = 0;
      while (j < i)
      {
        localObject2 = new UserListItemView(this.mContext, 0, false, false);
        ((UserListItemView)localObject2).setUin((String)((MQMsgBody)localObject1).vecUserAvatar.get(j));
        ((UserListItemView)localObject2).setTranslationX(AVATAR_GAP * j);
        this.mAvatarListLayout.addView((View)localObject2, 0);
        j += 1;
      }
      this.mImageShadow.setVisibility(8);
    }
    if (paramMQMsg.msgInteractData != null)
    {
      if ((paramMQMsg.msgInteractData.type == 1) && (paramMQMsg.msgInteractData.likeCell != null))
      {
        this.mLikeCommentContainer.setVisibility(0);
        if (paramMQMsg.msgInteractData.likeCell.liked)
        {
          this.mLikeIcon.setImageResource(2130848713);
        }
        else
        {
          localObject1 = this.mLikeIcon;
          if (paramBoolean2) {
            i = 2130848716;
          } else {
            i = 2130848715;
          }
          ((ImageView)localObject1).setImageResource(i);
        }
        if (paramMQMsg.msgInteractData.likeCell.totalLike > 0)
        {
          localObject1 = this.mLikeNum;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramMQMsg.msgInteractData.likeCell.totalLike);
          ((StringBuilder)localObject2).append("");
          ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
          this.mLikeNum.setVisibility(0);
        }
        else
        {
          this.mLikeNum.setText(HardCodeUtil.a(2131706990));
          this.mLikeNum.setVisibility(0);
        }
        if (paramMQMsg.msgInteractData.totalComment > 0)
        {
          localObject1 = this.mCommentNum;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramMQMsg.msgInteractData.totalComment);
          ((StringBuilder)localObject2).append("");
          ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
          this.mCommentNum.setVisibility(0);
        }
        else
        {
          this.mCommentNum.setText(HardCodeUtil.a(2131706991));
          this.mCommentNum.setVisibility(0);
        }
        if (paramBoolean2)
        {
          this.mLikeNum.setTextColor(-7500397);
          this.mCommentNum.setTextColor(-7500397);
          this.mCommentIcon.setImageResource(2130848708);
        }
      }
      if (paramMQMsg.msgInteractData.type == 2)
      {
        this.mShareContainer.setVisibility(0);
        if (paramBoolean2)
        {
          this.mQqshareIcon.setImageResource(2130848721);
          this.mQzoneshareIcon.setImageResource(2130848724);
          this.mQqshareText.setTextColor(-7500397);
          this.mQzoneshareText.setTextColor(-7500397);
        }
      }
      else if ((paramMQMsg.msgInteractData.type == 3) && (paramMQMsg.msgInteractData.buttonInfos != null) && (paramMQMsg.msgInteractData.buttonInfos.size() > 0))
      {
        localObject1 = (MQButtonCell)paramMQMsg.msgInteractData.buttonInfos.get(0);
        findViewById(2080571532).setVisibility(0);
        paramMQMsg = (TextView)findViewById(2080571534);
        paramMQMsg.setText(((MQButtonCell)localObject1).words);
        paramMQMsg.setTypeface(Typeface.DEFAULT_BOLD);
        localObject1 = getUrlDrawable(((MQButtonCell)localObject1).iconUrl);
        if (paramBoolean2)
        {
          paramMQMsg.setTextColor(-7500397);
          ((URLDrawable)localObject1).setColorFilter(-7500397, PorterDuff.Mode.SRC_ATOP);
        }
        else
        {
          ((URLDrawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        }
        ((ImageView)findViewById(2080571533)).setImageDrawable((Drawable)localObject1);
      }
    }
    showPersonalVipInfo();
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView
 * JD-Core Version:    0.7.0.1
 */