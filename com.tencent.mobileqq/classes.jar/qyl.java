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

public class qyl
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private rbi jdField_a_of_type_Rbi;
  public boolean a;
  
  public qyl(rbi paramrbi, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.jdField_a_of_type_Rbi = paramrbi;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    noy.a(paramContext, paramString);
  }
  
  private void a(ProgressBar paramProgressBar, TextView paramTextView, String paramString)
  {
    paramProgressBar.setProgress(0);
    paramTextView.setText(paramString);
    if (a())
    {
      this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Rbi.n.setText(paramString);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Rbi.r != null) && (this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, qyj paramqyj)
  {
    if ((paramDownloadInfo == null) || (paramqyj == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramqyj.d)) || (TextUtils.isEmpty(paramqyj.d))) {}
    while (!paramDownloadInfo.e.equals(paramqyj.d)) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Rbi != null) && (this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
  
  private void c(qyj paramqyj, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, paramqyj, paramInt));
        do
        {
          return;
        } while (paramqyj == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramqyj.d);
        }
        localTextView = this.jdField_a_of_type_Rbi.g;
        localProgressBar = this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localProgressBar == null) || (localTextView == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      localTextView.setText(alpo.a(2131700295));
      paramqyj.jdField_a_of_type_Int = 4;
      localProgressBar.setProgress(paramInt);
      paramqyj.b = paramInt;
      if (a())
      {
        this.jdField_a_of_type_Rbi.n.setText(alpo.a(2131700304));
        this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(paramqyj);
  }
  
  private void e(qyj paramqyj)
  {
    String str1 = paramqyj.d;
    String str2 = paramqyj.jdField_a_of_type_JavaLangString;
    String str3 = paramqyj.c;
    paramqyj = paramqyj.e;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bfjy.k, 5);
    localBundle.putString(bfjy.f, str1);
    localBundle.putString(bfjy.b, str2);
    localBundle.putString(bfjy.j, str3);
    localBundle.putString(bfjy.l, paramqyj);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramqyj + ", url:" + str3);
    }
    bfju.a(localBundle);
  }
  
  private void f(qyj paramqyj)
  {
    if ((this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramqyj != null) && (paramqyj.jdField_a_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqyj, paramqyj.b);
    }
  }
  
  private void g(qyj paramqyj)
  {
    if ((this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramqyj != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqyj, 0);
    }
  }
  
  private void h(qyj paramqyj)
  {
    d(paramqyj);
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this));
    }
    while ((this.jdField_a_of_type_Rbi == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Rbi.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Rbi.c != null) && (oee.a(this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a))) {
      this.jdField_a_of_type_Rbi.c.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rbi.d.setVisibility(8);
      this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      ImageView localImageView = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      if (!a()) {
        break;
      }
      this.jdField_a_of_type_Rbi.r.setVisibility(0);
      this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      if (this.jdField_a_of_type_Rbi.c != null) {
        this.jdField_a_of_type_Rbi.c.setVisibility(0);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, qyj paramqyj)
  {
    if (a(paramDownloadInfo, paramqyj)) {
      paramqyj.jdField_a_of_type_Int = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, qyj paramqyj)
  {
    if (a(paramDownloadInfo, paramqyj)) {
      a(paramqyj);
    }
  }
  
  public void a(String paramString1, String paramString2, qyj paramqyj)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramqyj)) {
      b(paramqyj);
    }
  }
  
  public void a(List<DownloadInfo> paramList, qyj paramqyj)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramqyj))
        {
          paramqyj.jdField_a_of_type_Int = 3;
          if ((TextUtils.isEmpty(paramqyj.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramqyj.c = localDownloadInfo.d;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            a();
          }
          b(paramqyj, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void a(qyj paramqyj)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, paramqyj));
        do
        {
          return;
        } while (paramqyj == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramqyj.d);
        }
        localTextView = this.jdField_a_of_type_Rbi.g;
        localProgressBar = this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      paramqyj.jdField_a_of_type_Int = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        paramqyj.b = i;
      }
      localProgressBar.setProgress(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c(paramqyj);
      }
      localTextView.setText(alpo.a(2131700297));
    } while (!a());
    this.jdField_a_of_type_Rbi.n.setText(alpo.a(2131700293));
  }
  
  public void a(qyj paramqyj, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, " updatUIByClick  cState = " + paramInt);
    }
    if (paramqyj == null)
    {
      QLog.d("ADVideoAppUIPresenter", 1, "updatUIByClick cgdtAppBtnData == null");
      paramqyj = this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetProgressBar;
      TextView localTextView = this.jdField_a_of_type_Rbi.g;
      ImageView localImageView = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        a(paramqyj, localTextView, alpo.a(2131700299));
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
        a(paramqyj, localTextView, alpo.a(2131700298));
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramqyj, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_AndroidContentContext, paramqyj.d);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      a(paramqyj);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(paramqyj);
      return;
    case 5: 
      e(paramqyj);
      return;
    }
    g(paramqyj);
  }
  
  public void b(DownloadInfo paramDownloadInfo, qyj paramqyj) {}
  
  public void b(String paramString1, String paramString2, qyj paramqyj)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramqyj)) {
      h(paramqyj);
    }
  }
  
  public void b(qyj paramqyj)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, paramqyj));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Rbi.g;
        localImageView = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (paramqyj == null) || (!paramqyj.a()));
      localTextView.setText(alpo.a(2131700306));
      paramqyj.jdField_a_of_type_Int = 1;
      if (a()) {
        this.jdField_a_of_type_Rbi.n.setText(alpo.a(2131700305));
      }
    } while (localImageView == null);
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842348);
  }
  
  public void b(qyj paramqyj, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    TextView localTextView;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, paramqyj, paramInt));
      do
      {
        return;
      } while ((paramqyj == null) || (paramqyj.jdField_a_of_type_Int != 3));
      localTextView = this.jdField_a_of_type_Rbi.g;
      localProgressBar = this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetProgressBar;
      localImageView = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetImageView;
    } while ((localTextView == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    localTextView.setText(alpo.a(2131700302) + paramInt + "%");
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (a())
    {
      this.jdField_a_of_type_Rbi.n.setText(alpo.a(2131700303) + paramInt + "%");
      this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    paramqyj.b = paramInt;
  }
  
  public void c(DownloadInfo paramDownloadInfo, qyj paramqyj)
  {
    if (a(paramDownloadInfo, paramqyj)) {
      d(paramqyj);
    }
  }
  
  public void c(String paramString1, String paramString2, qyj paramqyj) {}
  
  public void c(qyj paramqyj)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, paramqyj));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      do
      {
        return;
        localTextView = this.jdField_a_of_type_Rbi.g;
        localProgressBar = this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null) || (paramqyj == null) || (!paramqyj.a()));
      localTextView.setText(alpo.a(2131700294));
      localProgressBar.setProgress(100);
      if (a())
      {
        this.jdField_a_of_type_Rbi.n.setText(alpo.a(2131700300));
        this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
      paramqyj.b = 100;
      paramqyj.jdField_a_of_type_Int = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842348);
  }
  
  public void d(DownloadInfo paramDownloadInfo, qyj paramqyj)
  {
    if (a(paramDownloadInfo, paramqyj)) {
      c(paramqyj);
    }
  }
  
  public void d(qyj paramqyj)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.6(this, paramqyj));
    }
    TextView localTextView;
    do
    {
      return;
      localTextView = this.jdField_a_of_type_Rbi.g;
    } while ((localTextView == null) || (paramqyj == null));
    localTextView.setText(alpo.a(2131700296));
    if (a()) {
      this.jdField_a_of_type_Rbi.n.setText(alpo.a(2131700301));
    }
    paramqyj.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qyl
 * JD-Core Version:    0.7.0.1
 */