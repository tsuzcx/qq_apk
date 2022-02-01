package com.tencent.mobileqq.emotionintegrate;

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
import com.qq.taf.jce.HexUtil;
import com.tencent.common.galleryactivity.GalleryProgressView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import mqq.os.MqqHandler;

public class SearchEmoticonFragment
  extends AIOEmotionBaseFragment
  implements View.OnClickListener
{
  public static String a;
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity = null;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GalleryProgressView jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView;
  private SearchEmoticonWebBean jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean;
  private int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
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
    if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label361;
      }
    }
    label361:
    for (paramInt = 65537;; paramInt = 1)
    {
      paramQQAppInterface = URLDrawableHelper.getURL(paramMessageForPic, paramInt);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", paramQQAppInterface.toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      if (!new File(paramMessageForPic.path).exists()) {
        break label366;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("BUSI_TYPE", 1009);
      localIntent.putExtra("forward_is_tab_search_emo", true);
      return localIntent;
      paramInt = 0;
      break;
    }
    label366:
    paramQQAppInterface = null;
    paramContext = paramContext.getURL().toString();
    if (AbsDownloader.hasFile(paramContext))
    {
      paramContext = AbsDownloader.getFile(paramContext);
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null) {
        paramMessageForPic = paramContext.getAbsolutePath();
      }
    }
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
      paramContext = AbsDownloader.getFile(URLDrawableHelper.getURL(paramMessageForPic, 65537).toString());
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
    return paramLayoutInflater.inflate(2131563223, paramViewGroup, false);
  }
  
  protected void a() {}
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public boolean a()
  {
    return false;
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362403));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365716));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366295);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365715));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362400));
    ImageView localImageView = (ImageView)paramView.findViewById(2131362394);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView = new GalleryProgressView();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(super.getActivity(), localImageView);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838410);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 6.0F));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377802));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362219));
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
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i = AbsDownloader.getFilePath(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.b);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.jdField_d_of_type_Int != 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new SearchEmoticonFragment.1(this));
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
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_AndroidContentContext.getString(2131719718));
      paramIntent = new Bundle(paramIntent.getExtras());
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.a() != null) {
        ForwardUtils.a(super.a(), super.getActivity(), this.jdField_a_of_type_AndroidContentContext, localIntent, ThreadManager.getUIHandler());
      }
      ReportController.b(null, "dc00898", "", "", "0X8009EAC", "0X8009EAC", 0, 0, "", "", "", "");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = a();
    if (localObject == null) {
      QLog.d("SearchEmoticonFragment", 1, "error runtime");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, HardCodeUtil.a(2131713579), 0).a();
      }
      else
      {
        MessageForPic localMessageForPic = (MessageForPic)MessageRecordFactory.a(-2000);
        localMessageForPic.path = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i;
        localMessageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.i));
        localMessageForPic.thumbMsgUrl = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.b;
        localMessageForPic.bigMsgUrl = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateSearchEmoticonWebBean.b;
        localMessageForPic.imageType = 2000;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131362219: 
          URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
          localURLDrawable.setTag(localMessageForPic);
          AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)localObject, localURLDrawable, localMessageForPic.frienduin, getActivity().getResources().getDimensionPixelSize(2131299166), null, localMessageForPic.picExtraData);
          ReportController.b(null, "dc00898", "", "", "0X8009EAD", "0X8009EAD", 0, 0, "", "", "", "");
          EmoticonUtils.reportFavAddEmotionEvent((QQAppInterface)localObject, 5, localMessageForPic.md5, null);
          break;
        case 2131377802: 
          if (QLog.isColorLevel()) {
            QLog.d("SearchEmoticonFragment", 2, "发送给好友");
          }
          localObject = a(localMessageForPic, 0, (QQAppInterface)localObject, this.jdField_a_of_type_AndroidContentContext);
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
          ForwardBaseOption.a(super.getActivity(), (Intent)localObject, 1);
          a(localMessageForPic);
          ReportController.b(null, "dc00898", "", "", "0X8009EAA", "0X8009EAA", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ReportController.b(null, "dc00898", "", "", "0X8009EA9", "0X8009EA9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment
 * JD-Core Version:    0.7.0.1
 */