package cooperation.qzone.contentbox;

import ajjy;
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
import axwd;
import bajq;
import bfts;
import bftv;
import bftw;
import bftx;
import bfum;
import bgmb;
import bgor;
import bgqz;
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
  private static final int jdField_c_of_type_Int = bajq.b(36.0F);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bftv(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfum jdField_a_of_type_Bfum;
  private AnyScaleTypeImageView jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  private boolean jdField_a_of_type_Boolean;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bftw(this);
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
  private TextView h;
  private TextView i;
  
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
      int j = 0;
      while (j < paramArrayList.size())
      {
        MQPhotoCell localMQPhotoCell = (MQPhotoCell)paramArrayList.get(j);
        if ((localMQPhotoCell != null) && (!TextUtils.isEmpty(localMQPhotoCell.coverUrl))) {
          localArrayList.add(localMQPhotoCell.coverUrl);
        }
        j += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt1 == 0)) {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    boolean bool;
    label90:
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = new bftx(this.jdField_a_of_type_Bfts, this.jdField_g_of_type_AndroidWidgetImageView, paramInt2, this.jdField_a_of_type_Boolean);
        localObject2 = bgqz.a();
        if (paramInt3 != 1) {
          break;
        }
        bool = true;
        localObject1 = ((bgqz)localObject2).a(paramInt1, paramInt2, bool, false, "", 8, (VipResourcesListener)localObject1);
      } while (localObject1 == null);
      Object localObject2 = this.jdField_f_of_type_AndroidWidgetImageView;
      if (paramInt2 != 2) {
        break label144;
      }
      bool = true;
      ((ImageView)localObject2).setTag(Boolean.valueOf(bool));
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    } while (this.jdField_a_of_type_Boolean);
    if (paramInt2 == 2) {}
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      bgor.a(paramInt1, 1);
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
    this.jdField_a_of_type_Bfts = new bfts(this);
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496391, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297435));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297399));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305159));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)findViewById(2131297602));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager = ((QzoneMsgViewPager)findViewById(2131313342));
    d();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299451));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299452));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299453));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299454));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299455));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299456));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297425));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303514));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303515));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298908));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303518));
    this.h = ((TextView)findViewById(2131303522));
    this.i = ((TextView)findViewById(2131298948));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131310247));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131307496));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131308935));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131308545));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131313167));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302272));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302273));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302271));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void a(MQUserClientShowInfo paramMQUserClientShowInfo)
  {
    if ((paramMQUserClientShowInfo == null) || (TextUtils.isEmpty(paramMQUserClientShowInfo.unionVipUrl)) || (paramMQUserClientShowInfo.unionIconWidth == 0) || (paramMQUserClientShowInfo.unionIconHeight == 0)) {}
    do
    {
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((paramMQUserClientShowInfo.unionIconWidth > 0) && (paramMQUserClientShowInfo.unionIconHeight > 0))
      {
        localObject = this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = bajq.b(paramMQUserClientShowInfo.unionIconWidth / 2.0F);
        ((ViewGroup.LayoutParams)localObject).height = bajq.b(paramMQUserClientShowInfo.unionIconHeight / 2.0F);
        this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramMQUserClientShowInfo = paramMQUserClientShowInfo.unionVipUrl;
      Object localObject = new bgmb();
      ((bgmb)localObject).a(paramMQUserClientShowInfo, 10);
      ((bgmb)localObject).a(bajq.a() / 720.0F);
      ((bgmb)localObject).a(true);
      ((bgmb)localObject).a();
      ((bgmb)localObject).start();
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    } while (this.jdField_a_of_type_Boolean);
    bgor.a(12, 1);
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
        localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png", (URLDrawable.URLDrawableOptions)localObject);
      } while (localObject == null);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    } while (this.jdField_a_of_type_Boolean);
    bgor.a(13, 1);
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
    if (this.jdField_a_of_type_Bfts != null)
    {
      this.jdField_a_of_type_Bfts.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bfts = null;
    }
  }
  
  public void setData(boolean paramBoolean, MQMsg paramMQMsg)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    MQMsgBody localMQMsgBody = paramMQMsg.msgBody;
    Object localObject;
    if ((localMQMsgBody != null) && (localMQMsgBody.photolist != null))
    {
      if (localMQMsgBody.photolist.size() > 1)
      {
        if ((localMQMsgBody.photolist != null) && (localMQMsgBody.photolist.size() > 9)) {
          localMQMsgBody.photolist = new ArrayList(localMQMsgBody.photolist.subList(0, 9));
        }
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.setVisibility(0);
        localObject = a(localMQMsgBody.photolist);
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter = new QzoneMsgPagerAdapter(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject);
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.setAdapter(this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter);
      }
    }
    else
    {
      if (localMQMsgBody != null)
      {
        j = localMQMsgBody.mediaType;
        if (j != 1) {
          break label727;
        }
        if (!TextUtils.isEmpty(localMQMsgBody.content))
        {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(localMQMsgBody.content);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        label248:
        if (j == 3) {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if ((paramMQMsg.msgType != 9) || (TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          break label823;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramMQMsg.eventTitle);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText("摄于" + paramMQMsg.capTime);
        findViewById(2131308923).setVisibility(0);
        findViewById(2131311861).setVisibility(0);
        if (localMQMsgBody.photolist != null)
        {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_g_of_type_AndroidWidgetTextView.setText(" " + localMQMsgBody.photolist.size() + "张照片 ∙ 上传前仅自己可见");
        }
      }
      label415:
      if ((localMQMsgBody == null) || (localMQMsgBody.vecUserAvatar == null)) {
        break label898;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      if (5 >= localMQMsgBody.vecUserAvatar.size()) {
        break label877;
      }
    }
    label727:
    label877:
    for (int j = 5;; j = localMQMsgBody.vecUserAvatar.size())
    {
      int k = 0;
      while (k < j)
      {
        localObject = new UserListItemView(this.jdField_a_of_type_AndroidContentContext, 0);
        ((UserListItemView)localObject).setUin((String)localMQMsgBody.vecUserAvatar.get(k));
        ((UserListItemView)localObject).setTranslationX(jdField_c_of_type_Int * k);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, 0);
        k += 1;
      }
      if (localMQMsgBody.photolist.size() != 1) {
        break;
      }
      localObject = (MQPhotoCell)localMQMsgBody.photolist.get(0);
      if ((localObject == null) || (TextUtils.isEmpty(((MQPhotoCell)localObject).coverUrl))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setVisibility(0);
      switch (((MQPhotoCell)localObject).type)
      {
      default: 
        localObject = a(((MQPhotoCell)localObject).coverUrl);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject);
        break;
      case 1: 
        localObject = a(((MQPhotoCell)localObject).coverUrl);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject);
        break;
      case 2: 
        URLDrawable localURLDrawable = a();
        if (localURLDrawable != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(localURLDrawable);
          break;
        }
        localObject = a(((MQPhotoCell)localObject).coverUrl);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject);
        break;
      case 3: 
        localObject = a(((MQPhotoCell)localObject).coverUrl);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject);
        break;
        if (!TextUtils.isEmpty(localMQMsgBody.title))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(localMQMsgBody.title);
        }
        if (!TextUtils.isEmpty(localMQMsgBody.content))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(localMQMsgBody.content);
        }
        if ((!TextUtils.isEmpty(localMQMsgBody.title)) || (!TextUtils.isEmpty(localMQMsgBody.content))) {
          break label248;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label248;
        findViewById(2131308923).setVisibility(8);
        findViewById(2131311861).setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        break label415;
      }
    }
    label823:
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    label898:
    if (paramMQMsg.msgInteractData != null) {
      if ((paramMQMsg.msgInteractData.type == 1) && (paramMQMsg.msgInteractData.likeCell != null))
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (!paramMQMsg.msgInteractData.likeCell.liked) {
          break label1087;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847299);
        if (paramMQMsg.msgInteractData.likeCell.totalLike <= 0) {
          break label1100;
        }
        this.h.setText(paramMQMsg.msgInteractData.likeCell.totalLike + "");
        this.h.setVisibility(0);
        label1013:
        if (paramMQMsg.msgInteractData.totalComment <= 0) {
          break label1124;
        }
        this.i.setText(paramMQMsg.msgInteractData.totalComment + "");
        this.i.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramMQMsg.msgInteractData.type == 2) {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      f();
      return;
      label1087:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847300);
      break;
      label1100:
      this.h.setText(ajjy.a(2131641167));
      this.h.setVisibility(0);
      break label1013;
      label1124:
      this.i.setText(ajjy.a(2131641168));
      this.i.setVisibility(0);
    }
  }
  
  public void setMsgOnClickListener(bfum parambfum)
  {
    this.jdField_a_of_type_Bfum = parambfum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView
 * JD-Core Version:    0.7.0.1
 */