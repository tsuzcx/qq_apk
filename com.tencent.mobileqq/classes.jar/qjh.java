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

public class qjh
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private qmd jdField_a_of_type_Qmd;
  public boolean a;
  
  public qjh(qmd paramqmd, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.jdField_a_of_type_Qmd = paramqmd;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    nmf.a(paramContext, paramString);
  }
  
  private void a(ProgressBar paramProgressBar, TextView paramTextView, String paramString)
  {
    paramProgressBar.setProgress(0);
    paramTextView.setText(paramString);
    if (a())
    {
      this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Qmd.n.setText(paramString);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Qmd.r != null) && (this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, qjf paramqjf)
  {
    if ((paramDownloadInfo == null) || (paramqjf == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramqjf.d)) || (TextUtils.isEmpty(paramqjf.d))) {}
    while (!paramDownloadInfo.e.equals(paramqjf.d)) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.l.getVisibility() == 0);
  }
  
  private void c(qjf paramqjf, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, paramqjf, paramInt));
        do
        {
          return;
        } while (paramqjf == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramqjf.d);
        }
        localTextView = this.jdField_a_of_type_Qmd.g;
        localProgressBar = this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localProgressBar == null) || (localTextView == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      localTextView.setText(ajyc.a(2131699915));
      paramqjf.jdField_a_of_type_Int = 4;
      localProgressBar.setProgress(paramInt);
      paramqjf.b = paramInt;
      if (a())
      {
        this.jdField_a_of_type_Qmd.n.setText(ajyc.a(2131699924));
        this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(paramqjf);
  }
  
  private void e(qjf paramqjf)
  {
    String str1 = paramqjf.d;
    String str2 = paramqjf.jdField_a_of_type_JavaLangString;
    String str3 = paramqjf.c;
    paramqjf = paramqjf.e;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bdkm.k, 5);
    localBundle.putString(bdkm.f, str1);
    localBundle.putString(bdkm.b, str2);
    localBundle.putString(bdkm.j, str3);
    localBundle.putString(bdkm.l, paramqjf);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramqjf + ", url:" + str3);
    }
    bdki.a(localBundle);
  }
  
  private void f(qjf paramqjf)
  {
    if ((this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramqjf != null) && (paramqjf.jdField_a_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqjf, paramqjf.b);
    }
  }
  
  private void g(qjf paramqjf)
  {
    if ((this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramqjf != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqjf, 0);
    }
  }
  
  private void h(qjf paramqjf)
  {
    d(paramqjf);
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this));
    }
    while ((this.jdField_a_of_type_Qmd == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Qmd.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Qmd.c != null) && (oau.a(this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a))) {
      this.jdField_a_of_type_Qmd.c.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qmd.d.setVisibility(8);
      this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      ImageView localImageView = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      if (!a()) {
        break;
      }
      this.jdField_a_of_type_Qmd.r.setVisibility(0);
      this.jdField_a_of_type_Qmd.m.setVisibility(8);
      return;
      if (this.jdField_a_of_type_Qmd.c != null) {
        this.jdField_a_of_type_Qmd.c.setVisibility(0);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, qjf paramqjf)
  {
    if (a(paramDownloadInfo, paramqjf)) {
      paramqjf.jdField_a_of_type_Int = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, qjf paramqjf)
  {
    if (a(paramDownloadInfo, paramqjf)) {
      a(paramqjf);
    }
  }
  
  public void a(String paramString1, String paramString2, qjf paramqjf)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramqjf)) {
      b(paramqjf);
    }
  }
  
  public void a(List<DownloadInfo> paramList, qjf paramqjf)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramqjf))
        {
          paramqjf.jdField_a_of_type_Int = 3;
          if ((TextUtils.isEmpty(paramqjf.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramqjf.c = localDownloadInfo.d;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            a();
          }
          b(paramqjf, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void a(qjf paramqjf)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, paramqjf));
        do
        {
          return;
        } while (paramqjf == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramqjf.d);
        }
        localTextView = this.jdField_a_of_type_Qmd.g;
        localProgressBar = this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      paramqjf.jdField_a_of_type_Int = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        paramqjf.b = i;
      }
      localProgressBar.setProgress(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(paramqjf);
      }
      localTextView.setText(ajyc.a(2131699917));
    } while (!a());
    this.jdField_a_of_type_Qmd.n.setText(ajyc.a(2131699913));
  }
  
  public void a(qjf paramqjf, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, " updatUIByClick  cState = " + paramInt);
    }
    if (paramqjf == null)
    {
      QLog.d("ADVideoAppUIPresenter", 1, "updatUIByClick cgdtAppBtnData == null");
      paramqjf = this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetProgressBar;
      TextView localTextView = this.jdField_a_of_type_Qmd.g;
      ImageView localImageView = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        a(paramqjf, localTextView, ajyc.a(2131699919));
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
        a(paramqjf, localTextView, ajyc.a(2131699918));
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqjf, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_AndroidContentContext, paramqjf.d);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      a(paramqjf);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(paramqjf);
      return;
    case 5: 
      e(paramqjf);
      return;
    }
    g(paramqjf);
  }
  
  public void b(DownloadInfo paramDownloadInfo, qjf paramqjf) {}
  
  public void b(String paramString1, String paramString2, qjf paramqjf)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramqjf)) {
      h(paramqjf);
    }
  }
  
  public void b(qjf paramqjf)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, paramqjf));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Qmd.g;
        localImageView = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (paramqjf == null) || (!paramqjf.a()));
      localTextView.setText(ajyc.a(2131699926));
      paramqjf.jdField_a_of_type_Int = 1;
      if (a()) {
        this.jdField_a_of_type_Qmd.n.setText(ajyc.a(2131699925));
      }
    } while (localImageView == null);
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842183);
  }
  
  public void b(qjf paramqjf, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    TextView localTextView;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, paramqjf, paramInt));
      do
      {
        return;
      } while ((paramqjf == null) || (paramqjf.jdField_a_of_type_Int != 3));
      localTextView = this.jdField_a_of_type_Qmd.g;
      localProgressBar = this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetProgressBar;
      localImageView = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetImageView;
    } while ((localTextView == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    localTextView.setText(ajyc.a(2131699922) + paramInt + "%");
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (a())
    {
      this.jdField_a_of_type_Qmd.n.setText(ajyc.a(2131699923) + paramInt + "%");
      this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    paramqjf.b = paramInt;
  }
  
  public void c(DownloadInfo paramDownloadInfo, qjf paramqjf)
  {
    if (a(paramDownloadInfo, paramqjf)) {
      d(paramqjf);
    }
  }
  
  public void c(String paramString1, String paramString2, qjf paramqjf) {}
  
  public void c(qjf paramqjf)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, paramqjf));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Qmd.g;
        localProgressBar = this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null) || (paramqjf == null) || (!paramqjf.a()));
      localTextView.setText(ajyc.a(2131699914));
      localProgressBar.setProgress(100);
      if (a())
      {
        this.jdField_a_of_type_Qmd.n.setText(ajyc.a(2131699920));
        this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
      paramqjf.b = 100;
      paramqjf.jdField_a_of_type_Int = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842183);
  }
  
  public void d(DownloadInfo paramDownloadInfo, qjf paramqjf)
  {
    if (a(paramDownloadInfo, paramqjf)) {
      c(paramqjf);
    }
  }
  
  public void d(qjf paramqjf)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.6(this, paramqjf));
    }
    TextView localTextView;
    do
    {
      return;
      localTextView = this.jdField_a_of_type_Qmd.g;
    } while ((localTextView == null) || (paramqjf == null));
    localTextView.setText(ajyc.a(2131699916));
    if (a()) {
      this.jdField_a_of_type_Qmd.n.setText(ajyc.a(2131699921));
    }
    paramqjf.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjh
 * JD-Core Version:    0.7.0.1
 */