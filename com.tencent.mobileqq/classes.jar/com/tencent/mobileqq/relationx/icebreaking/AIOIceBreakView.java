package com.tencent.mobileqq.relationx.icebreaking;

import aism;
import aitc;
import aiti;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import bbbz;
import bbca;
import bbcb;
import bdll;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AIOIceBreakView
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bbbz(this);
  private bbcb jdField_a_of_type_Bbcb;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bbca(this);
  private CustomImgView jdField_b_of_type_ComTencentWidgetCustomImgView;
  private CustomImgView c;
  
  public AIOIceBreakView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public AIOIceBreakView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(aism paramaism)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramaism.a();
    paramaism = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramaism = URLDrawable.URLDrawableOptions.obtain();
    }
    paramaism.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaism.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaism.mPlayGifImage = true;
    return paramaism;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558617, this);
    ((TextView)localView.findViewById(2131380330)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)localView.findViewById(2131368596));
    this.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)localView.findViewById(2131368597));
    this.c = ((CustomImgView)localView.findViewById(2131368600));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838303);
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 6.0F));
  }
  
  private void a(aism paramaism)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "sendPic");
    }
    if (paramaism == null) {}
    do
    {
      return;
      paramaism = (aitc)paramaism;
      aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramaism.e());
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaism.l());
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("quick_send_original_md5", paramaism.c());
      localIntent.putExtra("quick_send_original_size", paramaism.a());
      localIntent.putExtra("quick_send_thumb_md5", paramaism.f());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
      localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
      ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, null), 8, null, false);
      paramaism = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramaism == null);
    paramaism.sendMessage(paramaism.obtainMessage(92));
  }
  
  private void a(CustomImgView paramCustomImgView, aism paramaism)
  {
    paramCustomImgView.setBackgroundDrawable(getResources().getDrawable(2130845063));
    if (paramaism == null)
    {
      paramCustomImgView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    Object localObject = paramaism.a();
    if (localObject == null)
    {
      paramCustomImgView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    localObject = paramaism.a((URL)localObject, a(paramaism));
    if ((paramaism instanceof aitc)) {
      paramCustomImgView.setContentDescription(((aitc)paramaism).e());
    }
    paramCustomImgView.setTag(paramaism);
    paramCustomImgView.setImageDrawable((Drawable)localObject);
    paramCustomImgView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<aism> paramList)
  {
    int i = 1;
    if ((paramList == null) || (paramList.size() < 3)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
      a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, (aism)paramList.get(0));
      a(this.jdField_b_of_type_ComTencentWidgetCustomImgView, (aism)paramList.get(1));
      a(this.c, (aism)paramList.get(2));
    } while (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1044);
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A4CA", "0X800A4CA", i, 0, "", "", "", "");
      return;
      i = 2;
    }
  }
  
  public void setOnIceImageClickListener(bbcb parambbcb)
  {
    this.jdField_a_of_type_Bbcb = parambbcb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView
 * JD-Core Version:    0.7.0.1
 */