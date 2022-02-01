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
  private ImageView a;
  private TextView b;
  private Button c;
  private Button d;
  private ImageView e;
  private SharedPreferences f = null;
  private Activity g;
  private CustomWebView h;
  private String i;
  private String j;
  private int k;
  private int l = 2;
  private CUKingCardHelper.CUKingDialogListener m;
  
  public CUKingCardDialog(Activity paramActivity, CustomWebView paramCustomWebView, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramActivity, 2131953338);
    this.g = paramActivity;
    this.h = paramCustomWebView;
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramInt1;
    this.l = paramInt2;
    a();
  }
  
  public CUKingCardDialog(Activity paramActivity, CUKingCardHelper.CUKingDialogListener paramCUKingDialogListener, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, 2131953338);
    this.g = paramActivity;
    this.m = paramCUKingDialogListener;
    this.j = paramString;
    this.k = paramInt1;
    this.l = paramInt2;
    a();
  }
  
  private void a()
  {
    setContentView(2131624576);
    this.a = ((ImageView)findViewById(2131429277));
    this.b = ((TextView)findViewById(2131438149));
    this.c = ((Button)findViewById(2131431522));
    this.d = ((Button)findViewById(2131431373));
    this.e = ((ImageView)findViewById(2131430272));
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CUKingCardFile_");
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    this.f = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    localObject1 = this.f.getString("guidePopupImgUrl_v2", "");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SP_KEY_GUIDE_POPUP_IMG_URL: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("CUKingCardDialog", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new ColorDrawable(this.g.getResources().getColor(2131168439));
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      this.a.setImageDrawable((Drawable)localObject1);
    }
    else
    {
      this.a.setImageDrawable((Drawable)localObject2);
    }
    localObject1 = this.f.getString("guidePopupText_v2", "");
    localObject2 = this.f.getString("guideJumpText_v2", "");
    Object localObject3 = this.f.getString("guideContinueText_v2", "");
    if (QLog.isColorLevel()) {
      QLog.i("CUKingCardDialog", 2, String.format("popUpType: %d, mSceneId: %d, popUpStr: %s, guideBtnStr: %s, continueBtnStr: %s", new Object[] { Integer.valueOf(this.l), Integer.valueOf(this.k), localObject1, localObject2, localObject3 }));
    }
    this.b.setText((CharSequence)localObject1);
    this.c.setText((CharSequence)localObject2);
    this.c.setOnClickListener(this);
    this.d.setText((CharSequence)localObject3);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void b()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((CUKingCardHelper.CUKingDialogListener)localObject).callback(3);
    }
    if (this.h != null) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("result", 3);
        this.h.callJs(this.i, new String[] { ((JSONObject)localObject).toString() });
      }
      catch (Exception localException)
      {
        QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException);
      }
    }
    int n = this.l;
    if (n == 2)
    {
      VasWebviewUtil.a("", "wkclub", "P2-3", this.j, 1, 0, 0, "", "", "");
      return;
    }
    if (n == 3) {
      VasWebviewUtil.a("", "wkclub", "P3-3", this.j, 1, 0, 0, "", "", "");
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    b();
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n != 2131430272)
    {
      if (n != 2131431373)
      {
        if (n == 2131431522)
        {
          Object localObject1 = CUKingCardHelper.a(this.j);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject3 = this.g;
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
              this.g.startActivity((Intent)localObject3);
            }
          }
          else
          {
            QLog.e("CUKingCardDialog", 1, "onClick cuGuideBtn url = null");
          }
          n = this.l;
          if (n == 2) {
            VasWebviewUtil.a("", "wkclub", "P2-1", this.j, 1, 0, 0, "", "", "");
          } else if (n == 3) {
            VasWebviewUtil.a("", "wkclub", "P3-1", this.j, 1, 0, 0, "", "", "");
          }
          localObject1 = this.m;
          if (localObject1 != null) {
            ((CUKingCardHelper.CUKingDialogListener)localObject1).callback(4);
          }
          dismiss();
          if (this.h != null) {
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("result", 4);
              this.h.callJs(this.i, new String[] { ((JSONObject)localObject1).toString() });
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
        Object localObject2 = this.m;
        if (localObject2 != null) {
          ((CUKingCardHelper.CUKingDialogListener)localObject2).callback(1);
        }
        dismiss();
        if (this.h != null) {
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("result", 1);
            this.h.callJs(this.i, new String[] { ((JSONObject)localObject2).toString() });
          }
          catch (Exception localException2)
          {
            QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException2);
          }
        }
        n = this.l;
        if (n == 2) {
          VasWebviewUtil.a("", "wkclub", "P2-2", this.j, 1, 0, 0, "", "", "");
        } else if (n == 3) {
          VasWebviewUtil.a("", "wkclub", "P3-2", this.j, 1, 0, 0, "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.CUKingCardDialog
 * JD-Core Version:    0.7.0.1
 */