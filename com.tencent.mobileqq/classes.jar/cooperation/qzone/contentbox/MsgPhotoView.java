package cooperation.qzone.contentbox;

import amtj;
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
import bkyt;
import blca;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgPhotoView
  extends BaseMsgView
{
  private static final int AVATAR_GAP = ViewUtils.dpToPx(36.0F);
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
  private boolean mIsRepeat;
  private LinearLayout mLikeCommentContainer;
  private RelativeLayout mLikeContainer;
  private ImageView mLikeIcon;
  private TextView mLikeNum;
  private TextView mNickNameView;
  private ImageView mQQUnionVipIcon;
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
    LayoutInflater.from(this.mContext).inflate(2131562351, this);
    this.mAvatarContainer = ((LinearLayout)findViewById(2131363162));
    this.mAvatarImage = ((ImageView)findViewById(2131363126));
    this.mNickNameView = ((TextView)findViewById(2131371791));
    this.mBackgroundImage = ((AnyScaleTypeImageView)findViewById(2131363427));
    this.mBackgroundImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.viewPager = ((QzoneMsgViewPager)findViewById(2131380800));
    initViewPager();
    this.mDesc1 = ((TextView)findViewById(2131365421));
    this.mDesc2 = ((TextView)findViewById(2131365422));
    this.mDesc3 = ((TextView)findViewById(2131365423));
    this.mDesc4 = ((TextView)findViewById(2131365424));
    this.mDesc5 = ((TextView)findViewById(2131365425));
    this.mDesc6 = ((TextView)findViewById(2131365426));
    this.mAvatarListLayout = ((FrameLayout)findViewById(2131363151));
    this.mLikeCommentContainer = ((LinearLayout)findViewById(2131369918));
    this.mLikeContainer = ((RelativeLayout)findViewById(2131369919));
    this.mCommentContainer = ((RelativeLayout)findViewById(2131364834));
    this.mLikeIcon = ((ImageView)findViewById(2131369922));
    this.mLikeNum = ((TextView)findViewById(2131369927));
    this.mCommentIcon = ((ImageView)findViewById(2131364850));
    this.mCommentNum = ((TextView)findViewById(2131364874));
    this.mShareContainer = ((LinearLayout)findViewById(2131377270));
    this.mShareQQView = ((RelativeLayout)findViewById(2131374317));
    this.mShareQzoneView = ((RelativeLayout)findViewById(2131375822));
    this.mQqshareIcon = ((ImageView)findViewById(2131374318));
    this.mQzoneshareIcon = ((ImageView)findViewById(2131375823));
    this.mQqshareText = ((TextView)findViewById(2131374319));
    this.mQzoneshareText = ((TextView)findViewById(2131375824));
    this.mLikeContainer.setOnClickListener(this.listener);
    this.mCommentContainer.setOnClickListener(this.listener);
    this.mShareQQView.setOnClickListener(this.listener);
    this.mShareQzoneView.setOnClickListener(this.listener);
    this.mImageShadow = ((ImageView)findViewById(2131375423));
    this.mVideoIcon = ((ImageView)findViewById(2131380589));
    this.mQQUnionVipIcon = ((ImageView)findViewById(2131368461));
    this.mVipYellowIcon = ((ImageView)findViewById(2131368462));
    this.mVipLoverYellowIcon = ((ImageView)findViewById(2131368460));
    this.mQQUnionVipIcon.setOnClickListener(this.mIconListener);
    this.mVipYellowIcon.setOnClickListener(this.mIconListener);
    this.mVipLoverYellowIcon.setOnClickListener(this.mIconListener);
    setOnClickListener(this.listener);
  }
  
  private void showLoverVipIcon(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
        localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png", (URLDrawable.URLDrawableOptions)localObject);
      } while (localObject == null);
      this.mVipLoverYellowIcon.setImageDrawable((Drawable)localObject);
      this.mVipLoverYellowIcon.setVisibility(0);
    } while (this.mIsRepeat);
    bkyt.a(13, 1);
  }
  
  private void showPersonalVipInfo()
  {
    if ((this.mData == null) || (this.mData.mqUserPersonalData == null) || (this.mData.mqUserPersonalData.mUserPersonalProfileMap == null))
    {
      QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo vip data = null");
      return;
    }
    MQUserPersonalProfile localMQUserPersonalProfile = (MQUserPersonalProfile)this.mData.mqUserPersonalData.mUserPersonalProfileMap.get(this.mData.user_avatar);
    if (localMQUserPersonalProfile == null)
    {
      QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo userPersonalProfile = null");
      return;
    }
    if (QZLog.isColorLevel()) {
      QZLog.i("MsgPhotoView", 2, "MsgVip showPersonalVipInfo isRepeat = " + this.mIsRepeat + "\n data = " + this.mData.mqUserPersonalData.convertToJson());
    }
    if ((localMQUserPersonalProfile.userClientShowInfo == null) || (localMQUserPersonalProfile.userClientShowInfo.iVip == 0) || (localMQUserPersonalProfile.userClientShowInfo.iLevel == 0))
    {
      showVipIcon(localMQUserPersonalProfile.vipLevel, localMQUserPersonalProfile.vip, localMQUserPersonalProfile.isAnnualVip);
      if (localMQUserPersonalProfile.isLoversVip != 1) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      showLoverVipIcon(bool);
      return;
      showQQUnionVipIcon(localMQUserPersonalProfile.userClientShowInfo);
      break;
    }
  }
  
  private void showQQUnionVipIcon(MQUserClientShowInfo paramMQUserClientShowInfo)
  {
    if ((paramMQUserClientShowInfo == null) || (TextUtils.isEmpty(paramMQUserClientShowInfo.unionVipUrl)) || (paramMQUserClientShowInfo.unionIconWidth == 0) || (paramMQUserClientShowInfo.unionIconHeight == 0)) {}
    do
    {
      return;
      this.mQQUnionVipIcon.setVisibility(0);
      this.mVipYellowIcon.setVisibility(8);
      this.mVipLoverYellowIcon.setVisibility(8);
      if ((paramMQUserClientShowInfo.unionIconWidth > 0) && (paramMQUserClientShowInfo.unionIconHeight > 0))
      {
        localObject = this.mQQUnionVipIcon.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = ViewUtils.dpToPx(paramMQUserClientShowInfo.unionIconWidth / 2.0F);
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.dpToPx(paramMQUserClientShowInfo.unionIconHeight / 2.0F);
        this.mQQUnionVipIcon.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramMQUserClientShowInfo = paramMQUserClientShowInfo.unionVipUrl;
      Object localObject = new ZipAnimationDrawable();
      ((ZipAnimationDrawable)localObject).setAnimationRes(paramMQUserClientShowInfo, 10);
      ((ZipAnimationDrawable)localObject).setScale(ViewUtils.getScreenWidth() / 720.0F);
      ((ZipAnimationDrawable)localObject).setRepeatAnimation(true);
      ((ZipAnimationDrawable)localObject).clearFirstFrame();
      ((ZipAnimationDrawable)localObject).start();
      this.mQQUnionVipIcon.setImageDrawable((Drawable)localObject);
    } while (this.mIsRepeat);
    bkyt.a(12, 1);
  }
  
  private void showVipIcon(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt1 == 0)) {
      this.mVipYellowIcon.setVisibility(8);
    }
    boolean bool;
    label91:
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = new MsgPhotoView.WeakVipResourcesListener(this.mUiHandler, this.mVipLoverYellowIcon, paramInt2, this.mIsRepeat);
        localObject2 = blca.a();
        if (paramInt3 != 1) {
          break;
        }
        bool = true;
        localObject1 = ((blca)localObject2).a(paramInt1, paramInt2, bool, false, "", 8, (VipResourcesListener)localObject1);
      } while (localObject1 == null);
      Object localObject2 = this.mVipYellowIcon;
      if (paramInt2 != 2) {
        break label145;
      }
      bool = true;
      ((ImageView)localObject2).setTag(Boolean.valueOf(bool));
      this.mVipYellowIcon.setImageDrawable((Drawable)localObject1);
      this.mVipYellowIcon.setVisibility(0);
    } while (this.mIsRepeat);
    if (paramInt2 == 2) {}
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      bkyt.a(paramInt1, 1);
      return;
      bool = false;
      break;
      label145:
      bool = false;
      break label91;
    }
  }
  
  protected boolean doHandleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (Drawable)paramMessage.obj;
      this.mAvatarImage.setImageDrawable(paramMessage);
    }
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
    if ((localObject1 != null) && (((MQMsgBody)localObject1).photolist != null)) {
      if (((MQMsgBody)localObject1).photolist.size() > 1) {
        if ((paramMQMsg.msgType != 9) || (TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          break label1555;
        }
      }
    }
    label786:
    label1313:
    for (int i = ((MQMsgBody)localObject1).photolist.size();; i = 0)
    {
      Object localObject2;
      if ((((MQMsgBody)localObject1).photolist != null) && (((MQMsgBody)localObject1).photolist.size() > 9))
      {
        if ((paramMQMsg.msgType == 9) && (!TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 3));
        }
      }
      else
      {
        this.viewPager.setVisibility(0);
        localObject2 = convert(((MQMsgBody)localObject1).photolist);
        this.pagerAdapter = new QzoneMsgPagerAdapter(this.mContext, (ArrayList)localObject2);
        this.viewPager.setAdapter(this.pagerAdapter);
      }
      label297:
      label1215:
      label1346:
      label1370:
      for (;;)
      {
        int j;
        if (localObject1 != null)
        {
          j = ((MQMsgBody)localObject1).mediaType;
          if (j != 1) {
            break label786;
          }
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
          {
            this.mDesc3.setVisibility(0);
            this.mDesc3.setText(((MQMsgBody)localObject1).content);
            this.mImageShadow.setVisibility(8);
          }
          if (j == 3) {
            this.mVideoIcon.setVisibility(0);
          }
          if ((paramMQMsg.msgType != 9) || (TextUtils.isEmpty(paramMQMsg.eventTitle))) {
            break label882;
          }
          this.mDesc4.setVisibility(0);
          this.mDesc4.setText(paramMQMsg.eventTitle);
          this.mDesc5.setVisibility(0);
          this.mDesc5.setText("摄于" + paramMQMsg.capTime);
          findViewById(2131375811).setVisibility(0);
          findViewById(2131379065).setVisibility(0);
          if (paramBoolean2)
          {
            ((ImageView)findViewById(2131379066)).setImageResource(2130848397);
            ((TextView)findViewById(2131379067)).setTextColor(-7500397);
          }
          if (((MQMsgBody)localObject1).photolist != null)
          {
            this.mDesc6.setVisibility(0);
            this.mDesc6.setText(" " + i + "张照片 ∙ 上传前仅自己可见");
          }
        }
        label494:
        if ((localObject1 != null) && (((MQMsgBody)localObject1).vecUserAvatar != null))
        {
          this.mAvatarListLayout.setVisibility(0);
          this.mAvatarListLayout.removeAllViews();
          if (5 < ((MQMsgBody)localObject1).vecUserAvatar.size()) {}
          for (i = 5;; i = ((MQMsgBody)localObject1).vecUserAvatar.size())
          {
            j = 0;
            while (j < i)
            {
              localObject2 = new UserListItemView(this.mContext, 0);
              ((UserListItemView)localObject2).setUin((String)((MQMsgBody)localObject1).vecUserAvatar.get(j));
              ((UserListItemView)localObject2).setTranslationX(AVATAR_GAP * j);
              this.mAvatarListLayout.addView((View)localObject2, 0);
              j += 1;
            }
            ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 9));
            break;
            if (((MQMsgBody)localObject1).photolist.size() != 1) {
              break label1549;
            }
            localObject2 = (MQPhotoCell)((MQMsgBody)localObject1).photolist.get(0);
            if ((localObject2 == null) || (TextUtils.isEmpty(((MQPhotoCell)localObject2).coverUrl))) {
              break label1549;
            }
            this.mBackgroundImage.setVisibility(0);
            switch (((MQPhotoCell)localObject2).type)
            {
            default: 
              localObject2 = getUrlDrawable(((MQPhotoCell)localObject2).coverUrl);
              this.mBackgroundImage.setImageDrawable((Drawable)localObject2);
              i = 0;
              break;
            case 2: 
              URLDrawable localURLDrawable = getApngDrawable();
              if (localURLDrawable != null)
              {
                this.mBackgroundImage.setImageDrawable(localURLDrawable);
                i = 0;
                break;
              }
              localObject2 = getUrlDrawable(((MQPhotoCell)localObject2).coverUrl);
              this.mBackgroundImage.setImageDrawable((Drawable)localObject2);
              i = 0;
              break;
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
              if ((!TextUtils.isEmpty(((MQMsgBody)localObject1).title)) || (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))) {
                break label297;
              }
              this.mImageShadow.setVisibility(8);
              break label297;
              label882:
              if (paramMQMsg.msgType == 11)
              {
                if (!TextUtils.isEmpty(paramMQMsg.msgBody.coverPicUrl))
                {
                  localObject2 = (ImageView)findViewById(2131375811);
                  ((ImageView)localObject2).setVisibility(0);
                  ((ImageView)localObject2).setImageDrawable(getUrlDrawable(paramMQMsg.msgBody.coverPicUrl));
                }
                this.mDesc1.setVisibility(8);
                this.mDesc6.setVisibility(0);
                this.mDesc6.setText(paramMQMsg.msgBody.content);
                break label494;
              }
              findViewById(2131375811).setVisibility(8);
              findViewById(2131379065).setVisibility(8);
              this.mDesc4.setVisibility(8);
              this.mDesc5.setVisibility(8);
              this.mDesc6.setVisibility(8);
              break label494;
            }
          }
          this.mImageShadow.setVisibility(8);
        }
        else
        {
          if (paramMQMsg.msgInteractData != null)
          {
            if ((paramMQMsg.msgInteractData.type == 1) && (paramMQMsg.msgInteractData.likeCell != null))
            {
              this.mLikeCommentContainer.setVisibility(0);
              if (!paramMQMsg.msgInteractData.likeCell.liked) {
                break label1313;
              }
              this.mLikeIcon.setImageResource(2130848385);
              if (paramMQMsg.msgInteractData.likeCell.totalLike <= 0) {
                break label1346;
              }
              this.mLikeNum.setText(paramMQMsg.msgInteractData.likeCell.totalLike + "");
              this.mLikeNum.setVisibility(0);
              if (paramMQMsg.msgInteractData.totalComment <= 0) {
                break label1370;
              }
              this.mCommentNum.setText(paramMQMsg.msgInteractData.totalComment + "");
              this.mCommentNum.setVisibility(0);
              if (paramBoolean2)
              {
                this.mLikeNum.setTextColor(-7500397);
                this.mCommentNum.setTextColor(-7500397);
                this.mCommentIcon.setImageResource(2130848380);
              }
            }
            if (paramMQMsg.msgInteractData.type != 2) {
              break label1394;
            }
            this.mShareContainer.setVisibility(0);
            if (paramBoolean2)
            {
              this.mQqshareIcon.setImageResource(2130848391);
              this.mQzoneshareIcon.setImageResource(2130848394);
              this.mQqshareText.setTextColor(-7500397);
              this.mQzoneshareText.setTextColor(-7500397);
            }
          }
          label1394:
          while ((paramMQMsg.msgInteractData.type != 3) || (paramMQMsg.msgInteractData.buttonInfos == null) || (paramMQMsg.msgInteractData.buttonInfos.size() <= 0))
          {
            showPersonalVipInfo();
            return;
            localObject1 = this.mLikeIcon;
            if (paramBoolean2) {}
            for (i = 2130848388;; i = 2130848387)
            {
              ((ImageView)localObject1).setImageResource(i);
              break;
            }
            this.mLikeNum.setText(amtj.a(2131706075));
            this.mLikeNum.setVisibility(0);
            break label1164;
            this.mCommentNum.setText(amtj.a(2131706076));
            this.mCommentNum.setVisibility(0);
            break label1215;
          }
          localObject1 = (MQButtonCell)paramMQMsg.msgInteractData.buttonInfos.get(0);
          findViewById(2131379065).setVisibility(0);
          paramMQMsg = (TextView)findViewById(2131379067);
          paramMQMsg.setText(((MQButtonCell)localObject1).words);
          paramMQMsg.setTypeface(Typeface.DEFAULT_BOLD);
          localObject1 = getUrlDrawable(((MQButtonCell)localObject1).iconUrl);
          if (paramBoolean2)
          {
            paramMQMsg.setTextColor(-7500397);
            ((URLDrawable)localObject1).setColorFilter(-7500397, PorterDuff.Mode.SRC_ATOP);
          }
          for (;;)
          {
            ((ImageView)findViewById(2131379066)).setImageDrawable((Drawable)localObject1);
            break;
            ((URLDrawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
          }
          i = 0;
        }
      }
    }
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView
 * JD-Core Version:    0.7.0.1
 */