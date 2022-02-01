package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.plugin.PluginBaseActivity;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class CUKingCardDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  private CUKingCardHelper.CUKingDialogListener jdField_a_of_type_ComTencentMobileqqVipCUKingCardHelper$CUKingDialogListener;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 2;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  
  public CUKingCardDialog(Activity paramActivity, CustomWebView paramCustomWebView, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramActivity, 2131756189);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    a();
  }
  
  public CUKingCardDialog(Activity paramActivity, CUKingCardHelper.CUKingDialogListener paramCUKingDialogListener, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, 2131756189);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqVipCUKingCardHelper$CUKingDialogListener = paramCUKingDialogListener;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    a();
  }
  
  private void a()
  {
    setContentView(2131558945);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363387));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370825));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365338));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131365207));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364259));
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CUKingCardFile_");
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    this.jdField_a_of_type_AndroidContentSharedPreferences = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guidePopupImgUrl_v2", "");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SP_KEY_GUIDE_POPUP_IMG_URL: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("CUKingCardDialog", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new ColorDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167384));
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    }
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guidePopupText_v2", "");
    localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guideJumpText_v2", "");
    Object localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guideContinueText_v2", "");
    if (QLog.isColorLevel()) {
      QLog.i("CUKingCardDialog", 2, String.format("popUpType: %d, mSceneId: %d, popUpStr: %s, guideBtnStr: %s, continueBtnStr: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), localObject1, localObject2, localObject3 }));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject3);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVipCUKingCardHelper$CUKingDialogListener;
    if (localObject != null) {
      ((CUKingCardHelper.CUKingDialogListener)localObject).callback(3);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("result", 3);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
      }
      catch (Exception localException)
      {
        QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException);
      }
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 2)
    {
      VasWebviewUtil.a("", "wkclub", "P2-3", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
      return;
    }
    if (i == 3) {
      VasWebviewUtil.a("", "wkclub", "P3-3", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    b();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364259)
    {
      if (i != 2131365207)
      {
        if (i == 2131365338)
        {
          Object localObject1 = CUKingCardHelper.a(this.jdField_b_of_type_JavaLangString);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject3 = this.jdField_a_of_type_AndroidAppActivity;
            if ((localObject3 instanceof PluginBaseActivity))
            {
              localObject3 = (PluginBaseActivity)localObject3;
              Intent localIntent = new Intent(((PluginBaseActivity)localObject3).getOutActivity(), QQBrowserActivity.class);
              localIntent.putExtra("url", (String)localObject1);
              localIntent.setFlags(268435456);
              ((PluginBaseActivity)localObject3).getOutActivity().startActivity(localIntent);
            }
            else
            {
              localObject3 = new Intent((Context)localObject3, QQBrowserActivity.class);
              ((Intent)localObject3).putExtra("url", (String)localObject1);
              this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject3);
            }
          }
          else
          {
            QLog.e("CUKingCardDialog", 1, "onClick cuGuideBtn url = null");
          }
          i = this.jdField_b_of_type_Int;
          if (i == 2) {
            VasWebviewUtil.a("", "wkclub", "P2-1", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
          } else if (i == 3) {
            VasWebviewUtil.a("", "wkclub", "P3-1", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqVipCUKingCardHelper$CUKingDialogListener;
          if (localObject1 != null) {
            ((CUKingCardHelper.CUKingDialogListener)localObject1).callback(4);
          }
          dismiss();
          if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("result", 4);
              this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
            }
            catch (Exception localException1)
            {
              QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException1);
            }
          }
        }
      }
      else
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVipCUKingCardHelper$CUKingDialogListener;
        if (localObject2 != null) {
          ((CUKingCardHelper.CUKingDialogListener)localObject2).callback(1);
        }
        dismiss();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("result", 1);
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
          }
          catch (Exception localException2)
          {
            QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException2);
          }
        }
        i = this.jdField_b_of_type_Int;
        if (i == 2) {
          VasWebviewUtil.a("", "wkclub", "P2-2", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
        } else if (i == 3) {
          VasWebviewUtil.a("", "wkclub", "P3-2", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
        }
      }
    }
    else
    {
      dismiss();
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.CUKingCardDialog
 * JD-Core Version:    0.7.0.1
 */