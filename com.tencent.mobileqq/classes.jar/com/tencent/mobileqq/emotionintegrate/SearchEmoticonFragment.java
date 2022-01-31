package com.tencent.mobileqq.emotionintegrate;

import agjb;
import alud;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqar;
import aryv;
import azaf;
import azqs;
import baqn;
import bayu;
import bdex;
import bdhb;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import mqq.os.MqqHandler;
import zji;

public class SearchEmoticonFragment
  extends AIOEmotionBaseFragment
  implements View.OnClickListener
{
  public static String a;
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private SearchEmoticonWebBean jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean;
  zji jdField_a_of_type_Zji;
  private int jdField_b_of_type_Int;
  public View b;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_JavaLangString = "forward_search_emoticon";
  }
  
  public static Intent a(MessageForPic paramMessageForPic, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 1);
    paramQQAppInterface.putInt("forward_source_uin_type", paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramMessageForPic.path);
    localIntent.putExtra(jdField_a_of_type_JavaLangString, true);
    localIntent.putExtra("forward_download_image_task_key", paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    localIntent.putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    localIntent.putExtra("forward_photo_isSend", paramMessageForPic.issend);
    localIntent.putExtra("forward_photo_md5", paramMessageForPic.md5);
    localIntent.putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    localIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    localIntent.putExtras(paramQQAppInterface);
    if ((bdex.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label352;
      }
    }
    label352:
    for (paramInt = 65537;; paramInt = 1)
    {
      paramQQAppInterface = bayu.a(paramMessageForPic, paramInt);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", paramQQAppInterface.toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      if (!new File(paramMessageForPic.path).exists()) {
        break label357;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("BUSI_TYPE", 1009);
      return localIntent;
      paramInt = 0;
      break;
    }
    label357:
    paramQQAppInterface = null;
    paramContext = paramContext.getURL().toString();
    if (baqn.b(paramContext))
    {
      paramContext = baqn.a(paramContext);
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null) {
        paramMessageForPic = paramContext.getAbsolutePath();
      }
    }
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
      paramContext = baqn.a(bayu.a(paramMessageForPic, 65537).toString());
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null)
      {
        paramMessageForPic = paramQQAppInterface;
        if (paramContext.exists()) {
          paramMessageForPic = paramContext.getAbsolutePath();
        }
      }
    }
  }
  
  public static void a(Context paramContext, SearchEmoticonWebBean paramSearchEmoticonWebBean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("SearchEmoticonWebBean", paramSearchEmoticonWebBean);
    PublicFragmentActivity.a(paramContext, localIntent, SearchEmoticonFragment.class);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    ThreadManager.getFileThreadHandler().post(new SearchEmoticonFragment.2(this, paramMessageForPic));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131562832, paramViewGroup, false);
  }
  
  protected void a() {}
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public boolean a()
  {
    return false;
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362272));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365147));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365710);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365146));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362270));
    ImageView localImageView = (ImageView)paramView.findViewById(2131362268);
    this.jdField_a_of_type_Zji = new zji();
    this.jdField_a_of_type_Zji.a(super.getActivity(), localImageView);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838180);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 6.0F));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376414));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362127));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean = ((SearchEmoticonWebBean)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("SearchEmoticonWebBean"));
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean = new SearchEmoticonWebBean();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.jdField_d_of_type_Int = 0;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mGifRoundCorner = this.jdField_b_of_type_Int;
    localURLDrawableOptions.mPlayGifImage = true;
    paramBundle = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.b, localURLDrawableOptions);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i = baqn.d(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.b);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.jdField_d_of_type_Int != 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new aqar(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.jdField_d_of_type_JavaLangString)) {
        paramBundle = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.jdField_d_of_type_JavaLangString, localURLDrawableOptions);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.jdField_d_of_type_Int != 1) {
        break label221;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.f);
    }
    label221:
    while (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.jdField_d_of_type_Int != 2) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.h);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_AndroidContentContext.getString(2131720582));
      paramIntent = new Bundle(paramIntent.getExtras());
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.a() != null) {
        ForwardUtils.a(super.a(), super.getActivity(), this.jdField_a_of_type_AndroidContentContext, localIntent, ThreadManager.getUIHandler());
      }
      azqs.b(null, "dc00898", "", "", "0X8009EAC", "0X8009EAC", 0, 0, "", "", "", "");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.d("SearchEmoticonFragment", 1, "error runtime");
      return;
    }
    if (!bdhb.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, alud.a(2131714016), 0).a();
      return;
    }
    MessageForPic localMessageForPic = (MessageForPic)azaf.a(-2000);
    localMessageForPic.path = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i;
    localMessageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i));
    localMessageForPic.thumbMsgUrl = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.b;
    localMessageForPic.bigMsgUrl = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.b;
    localMessageForPic.imageType = 2000;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362127: 
      paramView = (URLDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      paramView.setTag(localMessageForPic);
      agjb.a(this.jdField_a_of_type_AndroidContentContext, localQQAppInterface, paramView, localMessageForPic.frienduin, getActivity().getResources().getDimensionPixelSize(2131298914), null, localMessageForPic.picExtraData);
      azqs.b(null, "dc00898", "", "", "0X8009EAD", "0X8009EAD", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SearchEmoticonFragment", 2, "发送给好友");
    }
    paramView = a(localMessageForPic, 0, localQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
    aryv.a(super.getActivity(), paramView, 1);
    a(localMessageForPic);
    azqs.b(null, "dc00898", "", "", "0X8009EAA", "0X8009EAA", 0, 0, "", "", "", "");
  }
  
  public void onStart()
  {
    super.onStart();
    azqs.b(null, "dc00898", "", "", "0X8009EA9", "0X8009EA9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment
 * JD-Core Version:    0.7.0.1
 */