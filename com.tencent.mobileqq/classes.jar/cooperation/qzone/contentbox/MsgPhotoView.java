package cooperation.qzone.contentbox;

import alpo;
import android.content.Context;
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
import baul;
import bdkf;
import bjed;
import bjeg;
import bjeh;
import bjei;
import bjex;
import bjwu;
import bjzq;
import bkcl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.MQUserClientShowInfo;
import cooperation.qzone.contentbox.model.MQUserPersonalData;
import cooperation.qzone.contentbox.model.MQUserPersonalProfile;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgPhotoView
  extends BaseMsgView
{
  private static final int jdField_c_of_type_Int = bdkf.b(36.0F);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bjeg(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjex jdField_a_of_type_Bjex;
  private AnyScaleTypeImageView jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  private boolean jdField_a_of_type_Boolean;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bjeh(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private ImageView jdField_j_of_type_AndroidWidgetImageView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private TextView k;
  
  public MsgPhotoView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MsgPhotoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MsgPhotoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private ArrayList<String> a(ArrayList<MQPhotoCell> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int m = 0;
      while (m < paramArrayList.size())
      {
        MQPhotoCell localMQPhotoCell = (MQPhotoCell)paramArrayList.get(m);
        if ((localMQPhotoCell != null) && (!TextUtils.isEmpty(localMQPhotoCell.coverUrl))) {
          localArrayList.add(localMQPhotoCell.coverUrl);
        }
        m += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt1 == 0)) {
      this.jdField_i_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    boolean bool;
    label90:
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = new bjei(this.jdField_a_of_type_Bjed, this.jdField_j_of_type_AndroidWidgetImageView, paramInt2, this.jdField_a_of_type_Boolean);
        localObject2 = bkcl.a();
        if (paramInt3 != 1) {
          break;
        }
        bool = true;
        localObject1 = ((bkcl)localObject2).a(paramInt1, paramInt2, bool, false, "", 8, (VipResourcesListener)localObject1);
      } while (localObject1 == null);
      Object localObject2 = this.jdField_i_of_type_AndroidWidgetImageView;
      if (paramInt2 != 2) {
        break label144;
      }
      bool = true;
      ((ImageView)localObject2).setTag(Boolean.valueOf(bool));
      this.jdField_i_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_i_of_type_AndroidWidgetImageView.setVisibility(0);
    } while (this.jdField_a_of_type_Boolean);
    if (paramInt2 == 2) {}
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      bjzq.a(paramInt1, 1);
      return;
      bool = false;
      break;
      label144:
      bool = false;
      break label90;
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjed = new bjed(this);
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562181, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363010));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362973));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371142));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)findViewById(2131363188));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager = ((QzoneMsgViewPager)findViewById(2131379882));
    d();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365103));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365104));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365105));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365106));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365107));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365108));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131362999));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369414));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369415));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364539));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369418));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369423));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364555));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364580));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376515));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373658));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375133));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373659));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375134));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373660));
    this.k = ((TextView)findViewById(2131375135));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374738));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379671));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368028));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368029));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368027));
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_i_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_j_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void a(MQUserClientShowInfo paramMQUserClientShowInfo)
  {
    if ((paramMQUserClientShowInfo == null) || (TextUtils.isEmpty(paramMQUserClientShowInfo.unionVipUrl)) || (paramMQUserClientShowInfo.unionIconWidth == 0) || (paramMQUserClientShowInfo.unionIconHeight == 0)) {}
    do
    {
      return;
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((paramMQUserClientShowInfo.unionIconWidth > 0) && (paramMQUserClientShowInfo.unionIconHeight > 0))
      {
        localObject = this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = bdkf.b(paramMQUserClientShowInfo.unionIconWidth / 2.0F);
        ((ViewGroup.LayoutParams)localObject).height = bdkf.b(paramMQUserClientShowInfo.unionIconHeight / 2.0F);
        this.jdField_h_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramMQUserClientShowInfo = paramMQUserClientShowInfo.unionVipUrl;
      Object localObject = new bjwu();
      ((bjwu)localObject).a(paramMQUserClientShowInfo, 10);
      ((bjwu)localObject).a(bdkf.a() / 720.0F);
      ((bjwu)localObject).a(true);
      ((bjwu)localObject).a();
      ((bjwu)localObject).start();
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    } while (this.jdField_a_of_type_Boolean);
    bjzq.a(12, 1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
        localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png", (URLDrawable.URLDrawableOptions)localObject);
      } while (localObject == null);
      this.jdField_j_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
    } while (this.jdField_a_of_type_Boolean);
    bjzq.a(13, 1);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg == null) || (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData == null) || (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData.mUserPersonalProfileMap == null))
    {
      QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo vip data = null");
      return;
    }
    MQUserPersonalProfile localMQUserPersonalProfile = (MQUserPersonalProfile)this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData.mUserPersonalProfileMap.get(this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.user_avatar);
    if (localMQUserPersonalProfile == null)
    {
      QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo userPersonalProfile = null");
      return;
    }
    if (QZLog.isColorLevel()) {
      QZLog.i("MsgPhotoView", 2, "MsgVip showPersonalVipInfo isRepeat = " + this.jdField_a_of_type_Boolean + "\n data = " + this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData.convertToJson());
    }
    if ((localMQUserPersonalProfile.userClientShowInfo == null) || (localMQUserPersonalProfile.userClientShowInfo.iVip == 0) || (localMQUserPersonalProfile.userClientShowInfo.iLevel == 0))
    {
      a(localMQUserPersonalProfile.vipLevel, localMQUserPersonalProfile.vip, localMQUserPersonalProfile.isAnnualVip);
      if (localMQUserPersonalProfile.isLoversVip != 1) {
        break label205;
      }
    }
    label205:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
      a(localMQUserPersonalProfile.userClientShowInfo);
      break;
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (Drawable)paramMessage.obj;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessage);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Bjed != null)
    {
      this.jdField_a_of_type_Bjed.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bjed = null;
    }
  }
  
  public void setData(boolean paramBoolean1, MQMsg paramMQMsg, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    if (paramMQMsg == null) {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg = paramMQMsg;
    if ((!TextUtils.isEmpty(paramMQMsg.user_avatar)) && (!TextUtils.isEmpty(paramMQMsg.user_nick)))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ThreadManager.getSubThreadHandler().post(new MsgPhotoView.2(this, paramMQMsg));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMQMsg.user_nick);
    }
    Object localObject1 = paramMQMsg.msgBody;
    if ((localObject1 != null) && (((MQMsgBody)localObject1).photolist != null)) {
      if (((MQMsgBody)localObject1).photolist.size() > 1) {
        if ((paramMQMsg.msgType != 9) || (TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          break label1370;
        }
      }
    }
    label297:
    label850:
    label1370:
    for (int m = ((MQMsgBody)localObject1).photolist.size();; m = 0)
    {
      Object localObject2;
      int n;
      if ((((MQMsgBody)localObject1).photolist != null) && (((MQMsgBody)localObject1).photolist.size() > 9))
      {
        if ((paramMQMsg.msgType == 9) && (!TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 3));
        }
      }
      else
      {
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.setVisibility(0);
        localObject2 = a(((MQMsgBody)localObject1).photolist);
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter = new QzoneMsgPagerAdapter(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject2);
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.setAdapter(this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter);
        if (localObject1 != null)
        {
          n = ((MQMsgBody)localObject1).mediaType;
          if (n != 1) {
            break label850;
          }
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(((MQMsgBody)localObject1).content);
            this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          if (n == 3) {
            this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          if ((paramMQMsg.msgType != 9) || (TextUtils.isEmpty(paramMQMsg.eventTitle))) {
            break label946;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(paramMQMsg.eventTitle);
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_f_of_type_AndroidWidgetTextView.setText("摄于" + paramMQMsg.capTime);
          findViewById(2131375121).setVisibility(0);
          findViewById(2131378221).setVisibility(0);
          if (paramBoolean2)
          {
            ((ImageView)findViewById(2131378222)).setImageResource(2130847918);
            ((TextView)findViewById(2131378223)).setTextColor(-7500397);
          }
          if (((MQMsgBody)localObject1).photolist != null)
          {
            this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_g_of_type_AndroidWidgetTextView.setText(" " + m + "张照片 ∙ 上传前仅自己可见");
          }
        }
        label495:
        if ((localObject1 == null) || (((MQMsgBody)localObject1).vecUserAvatar == null)) {
          break label1022;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        if (5 >= ((MQMsgBody)localObject1).vecUserAvatar.size()) {
          break label1000;
        }
      }
      label1000:
      for (m = 5;; m = ((MQMsgBody)localObject1).vecUserAvatar.size())
      {
        n = 0;
        while (n < m)
        {
          localObject2 = new UserListItemView(this.jdField_a_of_type_AndroidContentContext, 0);
          ((UserListItemView)localObject2).setUin((String)((MQMsgBody)localObject1).vecUserAvatar.get(n));
          ((UserListItemView)localObject2).setTranslationX(jdField_c_of_type_Int * n);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject2, 0);
          n += 1;
        }
        ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 9));
        break;
        if (((MQMsgBody)localObject1).photolist.size() == 1)
        {
          localObject2 = (MQPhotoCell)((MQMsgBody)localObject1).photolist.get(0);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((MQPhotoCell)localObject2).coverUrl))) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setVisibility(0);
          }
        }
        switch (((MQPhotoCell)localObject2).type)
        {
        default: 
          localObject2 = a(((MQPhotoCell)localObject2).coverUrl);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject2);
          m = 0;
          break;
        case 1: 
          localObject2 = a(((MQPhotoCell)localObject2).coverUrl);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject2);
          m = 0;
          break;
        case 2: 
          URLDrawable localURLDrawable = a();
          if (localURLDrawable != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(localURLDrawable);
            m = 0;
            break;
          }
          localObject2 = a(((MQPhotoCell)localObject2).coverUrl);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject2);
          m = 0;
          break;
        case 3: 
          localObject2 = a(((MQPhotoCell)localObject2).coverUrl);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject2);
          m = 0;
          break;
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).title))
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setText(((MQMsgBody)localObject1).title);
          }
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((MQMsgBody)localObject1).content);
          }
          if ((!TextUtils.isEmpty(((MQMsgBody)localObject1).title)) || (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))) {
            break label297;
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
          break label297;
          findViewById(2131375121).setVisibility(8);
          findViewById(2131378221).setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          break label495;
        }
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      label1022:
      if (paramMQMsg.msgInteractData != null) {
        if ((paramMQMsg.msgInteractData.type == 1) && (paramMQMsg.msgInteractData.likeCell != null))
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (!paramMQMsg.msgInteractData.likeCell.liked) {
            break label1289;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847906);
          if (paramMQMsg.msgInteractData.likeCell.totalLike <= 0) {
            break label1322;
          }
          this.jdField_h_of_type_AndroidWidgetTextView.setText(paramMQMsg.msgInteractData.likeCell.totalLike + "");
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          if (paramMQMsg.msgInteractData.totalComment <= 0) {
            break label1346;
          }
          this.jdField_i_of_type_AndroidWidgetTextView.setText(paramMQMsg.msgInteractData.totalComment + "");
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      for (;;)
      {
        label1137:
        if (paramBoolean2)
        {
          this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-7500397);
          this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-7500397);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847901);
        }
        if (paramMQMsg.msgInteractData.type == 2)
        {
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (paramBoolean2)
          {
            this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130847912);
            this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847915);
            this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(-7500397);
            this.k.setTextColor(-7500397);
          }
        }
        f();
        return;
        localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
        if (paramBoolean2) {}
        for (m = 2130847909;; m = 2130847908)
        {
          ((ImageView)localObject1).setImageResource(m);
          break;
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setText(alpo.a(2131707335));
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        break label1137;
        this.jdField_i_of_type_AndroidWidgetTextView.setText(alpo.a(2131707336));
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  public void setMsgOnClickListener(bjex parambjex)
  {
    this.jdField_a_of_type_Bjex = parambjex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView
 * JD-Core Version:    0.7.0.1
 */