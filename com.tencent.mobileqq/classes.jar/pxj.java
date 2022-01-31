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

public class pxj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private qab jdField_a_of_type_Qab;
  public boolean a;
  
  public pxj(qab paramqab, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.jdField_a_of_type_Qab = paramqab;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    nbe.a(paramContext, paramString);
  }
  
  private void a(ProgressBar paramProgressBar, TextView paramTextView, String paramString)
  {
    paramProgressBar.setProgress(0);
    paramTextView.setText(paramString);
    if (a())
    {
      this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Qab.n.setText(paramString);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Qab.r != null) && (this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, pxh parampxh)
  {
    if ((paramDownloadInfo == null) || (parampxh == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(parampxh.d)) || (TextUtils.isEmpty(parampxh.d))) {}
    while (!paramDownloadInfo.e.equals(parampxh.d)) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Qab != null) && (this.jdField_a_of_type_Qab.o.getVisibility() == 0);
  }
  
  private void c(pxh parampxh, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, parampxh, paramInt));
        do
        {
          return;
        } while (parampxh == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + parampxh.d);
        }
        localTextView = this.jdField_a_of_type_Qab.g;
        localProgressBar = this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localProgressBar == null) || (localTextView == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      localTextView.setText(ajjy.a(2131634127));
      parampxh.jdField_a_of_type_Int = 4;
      localProgressBar.setProgress(paramInt);
      parampxh.b = paramInt;
      if (a())
      {
        this.jdField_a_of_type_Qab.n.setText(ajjy.a(2131634136));
        this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(parampxh);
  }
  
  private void e(pxh parampxh)
  {
    String str1 = parampxh.d;
    String str2 = parampxh.jdField_a_of_type_JavaLangString;
    String str3 = parampxh.c;
    parampxh = parampxh.e;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bcgl.k, 5);
    localBundle.putString(bcgl.f, str1);
    localBundle.putString(bcgl.b, str2);
    localBundle.putString(bcgl.j, str3);
    localBundle.putString(bcgl.l, parampxh);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + parampxh + ", url:" + str3);
    }
    bcgh.a(localBundle);
  }
  
  private void f(pxh parampxh)
  {
    if ((this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetProgressBar != null) && (parampxh != null) && (parampxh.jdField_a_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(parampxh, parampxh.b);
    }
  }
  
  private void g(pxh parampxh)
  {
    if ((this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetProgressBar != null) && (parampxh != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(parampxh, 0);
    }
  }
  
  private void h(pxh parampxh)
  {
    d(parampxh);
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this));
      do
      {
        return;
      } while ((this.jdField_a_of_type_Qab == null) || (!this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_Qab.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Qab.c.setVisibility(0);
      this.jdField_a_of_type_Qab.d.setVisibility(8);
      this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      ImageView localImageView = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    } while (!a());
    this.jdField_a_of_type_Qab.r.setVisibility(0);
    this.jdField_a_of_type_Qab.m.setVisibility(8);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, pxh parampxh)
  {
    if (a(paramDownloadInfo, parampxh)) {
      parampxh.jdField_a_of_type_Int = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, pxh parampxh)
  {
    if (a(paramDownloadInfo, parampxh)) {
      a(parampxh);
    }
  }
  
  public void a(String paramString1, String paramString2, pxh parampxh)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, parampxh)) {
      b(parampxh);
    }
  }
  
  public void a(List<DownloadInfo> paramList, pxh parampxh)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, parampxh))
        {
          parampxh.jdField_a_of_type_Int = 3;
          if ((TextUtils.isEmpty(parampxh.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            parampxh.c = localDownloadInfo.d;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            a();
          }
          b(parampxh, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void a(pxh parampxh)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, parampxh));
        do
        {
          return;
        } while (parampxh == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + parampxh.d);
        }
        localTextView = this.jdField_a_of_type_Qab.g;
        localProgressBar = this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      parampxh.jdField_a_of_type_Int = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        parampxh.b = i;
      }
      localProgressBar.setProgress(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(parampxh);
      }
      localTextView.setText(ajjy.a(2131634129));
    } while (!a());
    this.jdField_a_of_type_Qab.n.setText(ajjy.a(2131634125));
  }
  
  public void a(pxh parampxh, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, " updatUIByClick  cState = " + paramInt);
    }
    if (parampxh == null)
    {
      QLog.d("ADVideoAppUIPresenter", 1, "updatUIByClick cgdtAppBtnData == null");
      parampxh = this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetProgressBar;
      TextView localTextView = this.jdField_a_of_type_Qab.g;
      ImageView localImageView = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        a(parampxh, localTextView, ajjy.a(2131634131));
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
        a(parampxh, localTextView, ajjy.a(2131634130));
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(parampxh, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_AndroidContentContext, parampxh.d);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      a(parampxh);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(parampxh);
      return;
    case 5: 
      e(parampxh);
      return;
    }
    g(parampxh);
  }
  
  public void b(DownloadInfo paramDownloadInfo, pxh parampxh) {}
  
  public void b(String paramString1, String paramString2, pxh parampxh)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, parampxh)) {
      h(parampxh);
    }
  }
  
  public void b(pxh parampxh)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, parampxh));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Qab.g;
        localImageView = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (parampxh == null) || (!parampxh.a()));
      localTextView.setText(ajjy.a(2131634138));
      parampxh.jdField_a_of_type_Int = 1;
      if (a()) {
        this.jdField_a_of_type_Qab.n.setText(ajjy.a(2131634137));
      }
    } while (localImageView == null);
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842093);
  }
  
  public void b(pxh parampxh, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    TextView localTextView;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, parampxh, paramInt));
      do
      {
        return;
      } while ((parampxh == null) || (parampxh.jdField_a_of_type_Int != 3));
      localTextView = this.jdField_a_of_type_Qab.g;
      localProgressBar = this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetProgressBar;
      localImageView = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetImageView;
    } while ((localTextView == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    localTextView.setText(ajjy.a(2131634134) + paramInt + "%");
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (a())
    {
      this.jdField_a_of_type_Qab.n.setText(ajjy.a(2131634135) + paramInt + "%");
      this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    parampxh.b = paramInt;
  }
  
  public void c(DownloadInfo paramDownloadInfo, pxh parampxh)
  {
    if (a(paramDownloadInfo, parampxh)) {
      d(parampxh);
    }
  }
  
  public void c(String paramString1, String paramString2, pxh parampxh) {}
  
  public void c(pxh parampxh)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, parampxh));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Qab.g;
        localProgressBar = this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null) || (parampxh == null) || (!parampxh.a()));
      localTextView.setText(ajjy.a(2131634126));
      localProgressBar.setProgress(100);
      if (a())
      {
        this.jdField_a_of_type_Qab.n.setText(ajjy.a(2131634132));
        this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
      parampxh.b = 100;
      parampxh.jdField_a_of_type_Int = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842093);
  }
  
  public void d(DownloadInfo paramDownloadInfo, pxh parampxh)
  {
    if (a(paramDownloadInfo, parampxh)) {
      c(parampxh);
    }
  }
  
  public void d(pxh parampxh)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.6(this, parampxh));
    }
    TextView localTextView;
    do
    {
      return;
      localTextView = this.jdField_a_of_type_Qab.g;
    } while ((localTextView == null) || (parampxh == null));
    localTextView.setText(ajjy.a(2131634128));
    if (a()) {
      this.jdField_a_of_type_Qab.n.setText(ajjy.a(2131634133));
    }
    parampxh.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxj
 * JD-Core Version:    0.7.0.1
 */