import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.5;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.6;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.7;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.8;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.9;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class ohj
  implements DownloadListener
{
  protected int a;
  protected AnimatorSet a;
  protected Dialog a;
  public Context a;
  public View a;
  public AdProgressButton a;
  protected QQAppInterface a;
  public INetInfoHandler a;
  protected String a;
  protected ohb a;
  protected boolean a;
  protected int b;
  protected String b;
  public int c;
  protected String c;
  
  public static ohj a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        switch (paramJSONObject.optInt("moduleType"))
        {
        case 1: 
          if (paramJSONObject == null) {
            return paramJSONObject;
          }
          paramJSONObject.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
      paramJSONObject = oho.a(paramJSONObject.optJSONObject("singleImageModule"));
      continue;
      paramJSONObject = ohr.a(paramJSONObject.optJSONObject("mixVideoModule"));
      continue;
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (this.jdField_a_of_type_Ohb == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Ohb.f)) || (TextUtils.isEmpty(this.jdField_a_of_type_Ohb.d))) {}
    while ((!paramDownloadInfo.e.equals(this.jdField_a_of_type_Ohb.f)) || (!paramDownloadInfo.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Ohb.d))) {
      return false;
    }
    return true;
  }
  
  private void d()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131717691), 0).b(0);
      return;
    }
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext))
    {
      e();
      return;
    }
    f();
  }
  
  private void e()
  {
    ois.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ohb, this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717787));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839381);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    }
    this.jdField_c_of_type_Int = 3;
    ois.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = ois.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131717795), new ohm(this), this.jdField_a_of_type_AndroidContentContext.getString(2131717796), new ohn(this), this.jdField_a_of_type_AndroidContentContext.getString(2131717797));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Int == 3)
    {
      bjna.a().a(this.jdField_a_of_type_Ohb.d);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131717798), 0).b(0);
      ThreadManager.getUIHandler().post(new AdModuleBase.5(this));
    }
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, ohb paramohb, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Ohb = paramohb;
    this.jdField_a_of_type_Boolean = paramBoolean;
    return null;
  }
  
  public void a()
  {
    AdProgressButton localAdProgressButton;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Ohb != null) && (this.jdField_a_of_type_Ohb.jdField_a_of_type_Int == 2))
    {
      localAdProgressButton = (AdProgressButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373233);
      if (this.jdField_a_of_type_Ohb.jdField_b_of_type_Int != 2) {
        break label70;
      }
      localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717801));
    }
    label70:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ohb.jdField_b_of_type_Int != 1);
      if (ois.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ohb.f))
      {
        localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717799));
        this.jdField_c_of_type_Int = 1;
        return;
      }
      if (oil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ohb.f))
      {
        localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717792));
        this.jdField_c_of_type_Int = 2;
        return;
      }
    } while (this.jdField_c_of_type_Int == 3);
    localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717786));
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(Context paramContext, View paramView)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131560277, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((ViewGroup)paramView).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (((this.jdField_a_of_type_Ohb == null) || (this.jdField_a_of_type_Ohb.jdField_a_of_type_Int != 1)) && (!this.jdField_a_of_type_Boolean) && ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)))
    {
      paramView.findViewById(2131378965).setVisibility(0);
      if (this.jdField_b_of_type_Int == 1) {
        paramView.findViewById(2131378967).setVisibility(8);
      }
      localObject1 = paramView.findViewById(2131380602);
      localObject2 = paramView.findViewById(2131380603);
      ((View)localObject1).setAlpha(0.0F);
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setAlpha(0.0F);
      ((View)localObject2).setVisibility(0);
      localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      ((ObjectAnimator)localObject2).setDuration(1800L);
      ((ObjectAnimator)localObject2).setRepeatCount(-1);
      ((ObjectAnimator)localObject2).setRepeatMode(1);
      ((ObjectAnimator)localObject2).setStartDelay(100L);
      ((ObjectAnimator)localObject1).setDuration(1800L);
      ((ObjectAnimator)localObject1).setRepeatCount(-1);
      ((ObjectAnimator)localObject1).setRepeatMode(1);
      ((ObjectAnimator)localObject1).setStartDelay(240L);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject2, localObject1 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ohb != null) && (this.jdField_a_of_type_Ohb.jdField_a_of_type_Int == 2)) {
      paramView.findViewById(2131365830).setVisibility(0);
    }
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_Ohb.jdField_a_of_type_JavaLangString);
      ((ResizeURLImageView)paramView.findViewById(2131365842)).setImage((URL)localObject1);
      ((TextView)paramView.findViewById(2131365839)).setText(this.jdField_a_of_type_Ohb.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)paramView.findViewById(2131373233));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(paramContext.getResources().getColor(2131165381));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(new ohk(this));
      int i = ois.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ohb);
      if (i >= 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717787));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839381);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(i);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
        this.jdField_c_of_type_Int = 3;
        bjna.a().a(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ohl(this);
        AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public abstract void b();
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Boolean) {
      bjna.a().b(this);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new AdModuleBase.7(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new AdModuleBase.9(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new AdModuleBase.6(this));
      ois.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (a(localDownloadInfo)) {
        ThreadManager.getUIHandler().post(new AdModuleBase.8(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohj
 * JD-Core Version:    0.7.0.1
 */