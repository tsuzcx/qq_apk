import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.2;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.3;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.4;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.5;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.6;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.7;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class qje
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private qma jdField_a_of_type_Qma;
  public boolean a;
  
  public qje(qma paramqma, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.jdField_a_of_type_Qma = paramqma;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    nmc.a(paramContext, paramString);
  }
  
  private void a(ProgressBar paramProgressBar, TextView paramTextView, String paramString)
  {
    paramProgressBar.setProgress(0);
    paramTextView.setText(paramString);
    if (a())
    {
      this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Qma.n.setText(paramString);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Qma.r != null) && (this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, qjc paramqjc)
  {
    if ((paramDownloadInfo == null) || (paramqjc == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramqjc.d)) || (TextUtils.isEmpty(paramqjc.d))) {}
    while (!paramDownloadInfo.e.equals(paramqjc.d)) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Qma != null) && (this.jdField_a_of_type_Qma.l.getVisibility() == 0);
  }
  
  private void c(qjc paramqjc, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, paramqjc, paramInt));
        do
        {
          return;
        } while (paramqjc == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramqjc.d);
        }
        localTextView = this.jdField_a_of_type_Qma.g;
        localProgressBar = this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localProgressBar == null) || (localTextView == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      localTextView.setText(ajya.a(2131699926));
      paramqjc.jdField_a_of_type_Int = 4;
      localProgressBar.setProgress(paramInt);
      paramqjc.b = paramInt;
      if (a())
      {
        this.jdField_a_of_type_Qma.n.setText(ajya.a(2131699935));
        this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(paramqjc);
  }
  
  private void e(qjc paramqjc)
  {
    String str1 = paramqjc.d;
    String str2 = paramqjc.jdField_a_of_type_JavaLangString;
    String str3 = paramqjc.c;
    paramqjc = paramqjc.e;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bdlb.k, 5);
    localBundle.putString(bdlb.f, str1);
    localBundle.putString(bdlb.b, str2);
    localBundle.putString(bdlb.j, str3);
    localBundle.putString(bdlb.l, paramqjc);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramqjc + ", url:" + str3);
    }
    bdkx.a(localBundle);
  }
  
  private void f(qjc paramqjc)
  {
    if ((this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramqjc != null) && (paramqjc.jdField_a_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqjc, paramqjc.b);
    }
  }
  
  private void g(qjc paramqjc)
  {
    if ((this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramqjc != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqjc, 0);
    }
  }
  
  private void h(qjc paramqjc)
  {
    d(paramqjc);
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this));
    }
    while ((this.jdField_a_of_type_Qma == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Qma.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Qma.c != null) && (oar.a(this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a))) {
      this.jdField_a_of_type_Qma.c.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qma.d.setVisibility(8);
      this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      ImageView localImageView = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      if (!a()) {
        break;
      }
      this.jdField_a_of_type_Qma.r.setVisibility(0);
      this.jdField_a_of_type_Qma.m.setVisibility(8);
      return;
      if (this.jdField_a_of_type_Qma.c != null) {
        this.jdField_a_of_type_Qma.c.setVisibility(0);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, qjc paramqjc)
  {
    if (a(paramDownloadInfo, paramqjc)) {
      paramqjc.jdField_a_of_type_Int = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, qjc paramqjc)
  {
    if (a(paramDownloadInfo, paramqjc)) {
      a(paramqjc);
    }
  }
  
  public void a(String paramString1, String paramString2, qjc paramqjc)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramqjc)) {
      b(paramqjc);
    }
  }
  
  public void a(List<DownloadInfo> paramList, qjc paramqjc)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramqjc))
        {
          paramqjc.jdField_a_of_type_Int = 3;
          if ((TextUtils.isEmpty(paramqjc.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramqjc.c = localDownloadInfo.d;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            a();
          }
          b(paramqjc, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void a(qjc paramqjc)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, paramqjc));
        do
        {
          return;
        } while (paramqjc == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramqjc.d);
        }
        localTextView = this.jdField_a_of_type_Qma.g;
        localProgressBar = this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      paramqjc.jdField_a_of_type_Int = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        paramqjc.b = i;
      }
      localProgressBar.setProgress(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(paramqjc);
      }
      localTextView.setText(ajya.a(2131699928));
    } while (!a());
    this.jdField_a_of_type_Qma.n.setText(ajya.a(2131699924));
  }
  
  public void a(qjc paramqjc, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, " updatUIByClick  cState = " + paramInt);
    }
    if (paramqjc == null)
    {
      QLog.d("ADVideoAppUIPresenter", 1, "updatUIByClick cgdtAppBtnData == null");
      paramqjc = this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetProgressBar;
      TextView localTextView = this.jdField_a_of_type_Qma.g;
      ImageView localImageView = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        a(paramqjc, localTextView, ajya.a(2131699930));
        if (this.jdField_a_of_type_Boolean) {
          break label141;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
        if (localImageView != null) {
          localImageView.setVisibility(8);
        }
        a(paramqjc, localTextView, ajya.a(2131699929));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.e();
        break;
        label141:
        bool = false;
      }
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqjc, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_AndroidContentContext, paramqjc.d);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      a(paramqjc);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(paramqjc);
      return;
    case 5: 
      e(paramqjc);
      return;
    }
    g(paramqjc);
  }
  
  public void b(DownloadInfo paramDownloadInfo, qjc paramqjc) {}
  
  public void b(String paramString1, String paramString2, qjc paramqjc)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramqjc)) {
      h(paramqjc);
    }
  }
  
  public void b(qjc paramqjc)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, paramqjc));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Qma.g;
        localImageView = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (paramqjc == null) || (!paramqjc.a()));
      localTextView.setText(ajya.a(2131699937));
      paramqjc.jdField_a_of_type_Int = 1;
      if (a()) {
        this.jdField_a_of_type_Qma.n.setText(ajya.a(2131699936));
      }
    } while (localImageView == null);
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842184);
  }
  
  public void b(qjc paramqjc, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    TextView localTextView;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, paramqjc, paramInt));
      do
      {
        return;
      } while ((paramqjc == null) || (paramqjc.jdField_a_of_type_Int != 3));
      localTextView = this.jdField_a_of_type_Qma.g;
      localProgressBar = this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetProgressBar;
      localImageView = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetImageView;
    } while ((localTextView == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    localTextView.setText(ajya.a(2131699933) + paramInt + "%");
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (a())
    {
      this.jdField_a_of_type_Qma.n.setText(ajya.a(2131699934) + paramInt + "%");
      this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    paramqjc.b = paramInt;
  }
  
  public void c(DownloadInfo paramDownloadInfo, qjc paramqjc)
  {
    if (a(paramDownloadInfo, paramqjc)) {
      d(paramqjc);
    }
  }
  
  public void c(String paramString1, String paramString2, qjc paramqjc) {}
  
  public void c(qjc paramqjc)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, paramqjc));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Qma.g;
        localProgressBar = this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null) || (paramqjc == null) || (!paramqjc.a()));
      localTextView.setText(ajya.a(2131699925));
      localProgressBar.setProgress(100);
      if (a())
      {
        this.jdField_a_of_type_Qma.n.setText(ajya.a(2131699931));
        this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
      paramqjc.b = 100;
      paramqjc.jdField_a_of_type_Int = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842184);
  }
  
  public void d(DownloadInfo paramDownloadInfo, qjc paramqjc)
  {
    if (a(paramDownloadInfo, paramqjc)) {
      c(paramqjc);
    }
  }
  
  public void d(qjc paramqjc)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.6(this, paramqjc));
    }
    TextView localTextView;
    do
    {
      return;
      localTextView = this.jdField_a_of_type_Qma.g;
    } while ((localTextView == null) || (paramqjc == null));
    localTextView.setText(ajya.a(2131699927));
    if (a()) {
      this.jdField_a_of_type_Qma.n.setText(ajya.a(2131699932));
    }
    paramqjc.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qje
 * JD-Core Version:    0.7.0.1
 */