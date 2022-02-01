import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppUIPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppUIPresenter.2;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppUIPresenter.3;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppUIPresenter.4;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppUIPresenter.5;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppUIPresenter.7;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppUIPresenter.8;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ore
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager;
  private rxl jdField_a_of_type_Rxl;
  public boolean a;
  
  public ore(rxl paramrxl, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.jdField_a_of_type_Rxl = paramrxl;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    nxw.a(paramContext, paramString);
  }
  
  private void a(ProgressBar paramProgressBar, TextView paramTextView, String paramString)
  {
    paramProgressBar.setProgress(0);
    paramTextView.setText(paramString);
    if (a())
    {
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Rxl.l.setText(paramString);
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Rxl == null) {
      return;
    }
    TextView localTextView1 = this.jdField_a_of_type_Rxl.e;
    TextView localTextView2 = this.jdField_a_of_type_Rxl.l;
    TextView localTextView3 = this.jdField_a_of_type_Rxl.k;
    TextView localTextView4 = this.jdField_a_of_type_Rxl.d;
    opr.a(localTextView1, paramString);
    opr.a(localTextView2, paramString);
    opr.a(localTextView3, paramString);
    opr.a(localTextView4, paramString);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Rxl.p != null) && (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, orb paramorb)
  {
    if ((paramDownloadInfo == null) || (paramorb == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramorb.d)) || (TextUtils.isEmpty(paramorb.d))) {
      return false;
    }
    return paramDownloadInfo.e.equals(paramorb.d);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Rxl != null) && (this.jdField_a_of_type_Rxl.o.getVisibility() == 0);
  }
  
  private void c(orb paramorb, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ProgressBar localProgressBar;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, paramorb, paramInt));
        do
        {
          return;
        } while (paramorb == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramorb.d);
        }
        localProgressBar = this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetProgressBar;
        localObject = this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetImageView;
      } while (localProgressBar == null);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      Object localObject = anni.a(2131698733);
      opr.a(this.jdField_a_of_type_Rxl.e, (String)localObject);
      paramorb.jdField_a_of_type_Int = 4;
      localProgressBar.setProgress(paramInt);
      paramorb.b = paramInt;
      if (a())
      {
        opr.a(this.jdField_a_of_type_Rxl.l, (String)localObject);
        this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.c(paramorb);
  }
  
  private void e(orb paramorb)
  {
    String str1 = paramorb.d;
    String str2 = paramorb.jdField_a_of_type_JavaLangString;
    String str3 = paramorb.c;
    paramorb = paramorb.e;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bivp.k, 5);
    localBundle.putString(bivp.f, str1);
    localBundle.putString(bivp.b, str2);
    localBundle.putString(bivp.j, str3);
    localBundle.putString(bivp.l, paramorb);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramorb + ", url:" + str3);
    }
    bivl.a(localBundle);
  }
  
  private void f(orb paramorb)
  {
    if ((this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramorb != null) && (paramorb.jdField_a_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a(paramorb, paramorb.b);
    }
  }
  
  private void g(orb paramorb)
  {
    if ((this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramorb != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a(paramorb, 0);
    }
  }
  
  private void h(orb paramorb)
  {
    olc.a(paramorb, new orf(this, paramorb));
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.8(this));
    }
    while ((this.jdField_a_of_type_Rxl == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Rxl.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidViewView != null)
    {
      if (!oqj.a(this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a)) {
        break label157;
      }
      this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      ImageView localImageView = this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      if (!a()) {
        break;
      }
      this.jdField_a_of_type_Rxl.p.setVisibility(0);
      this.jdField_a_of_type_Rxl.k.setVisibility(8);
      return;
      label157:
      this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, orb paramorb)
  {
    if (a(paramDownloadInfo, paramorb)) {
      paramorb.jdField_a_of_type_Int = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, orb paramorb)
  {
    if (a(paramDownloadInfo, paramorb)) {
      a(paramorb);
    }
  }
  
  public void a(String paramString1, String paramString2, orb paramorb)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramorb)) {
      b(paramorb);
    }
  }
  
  public void a(List<DownloadInfo> paramList, orb paramorb)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramorb))
        {
          paramorb.jdField_a_of_type_Int = 3;
          if ((TextUtils.isEmpty(paramorb.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramorb.c = localDownloadInfo.d;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            a();
          }
          b(paramorb, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void a(orb paramorb)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, paramorb));
    }
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        return;
        if (paramorb == null) {
          break;
        }
        oqh.a("ADVideoAppDownloadManager", "pauseDownloadUi " + paramorb.d);
        localTextView = this.jdField_a_of_type_Rxl.e;
        localProgressBar = this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      paramorb.jdField_a_of_type_Int = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        paramorb.b = i;
      }
      localProgressBar.setProgress(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.c(paramorb);
      }
      paramorb = anni.a(2131698735);
      opr.a(this.jdField_a_of_type_Rxl.e, paramorb);
    } while (!a());
    opr.a(this.jdField_a_of_type_Rxl.l, paramorb);
    return;
    oqh.a("ADVideoAppDownloadManager", "pauseDownloadUi : appDownloadData = null");
  }
  
  public void a(orb paramorb, int paramInt)
  {
    boolean bool = true;
    oqh.a("ADVideoAppDownloadManager", "updatUIByClick  cState = " + paramInt);
    if (paramorb == null)
    {
      oqh.a("ADVideoAppDownloadManager", "updatUIByClick cgdtAppBtnData == null");
      paramorb = this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetProgressBar;
      TextView localTextView = this.jdField_a_of_type_Rxl.e;
      ImageView localImageView = this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        a(paramorb, localTextView, anni.a(2131698737));
        if (this.jdField_a_of_type_Boolean) {
          break label135;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
        if (localImageView != null) {
          localImageView.setVisibility(8);
        }
        a(paramorb, localTextView, anni.a(2131698736));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.e();
        break;
        label135:
        bool = false;
      }
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a(paramorb, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_AndroidContentContext, paramorb.d);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      a(paramorb);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(paramorb);
      return;
    case 5: 
      e(paramorb);
      return;
    }
    g(paramorb);
  }
  
  public void b(DownloadInfo paramDownloadInfo, orb paramorb) {}
  
  public void b(String paramString1, String paramString2, orb paramorb)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramorb)) {
      h(paramorb);
    }
  }
  
  public void b(orb paramorb)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, paramorb));
      do
      {
        return;
      } while ((paramorb == null) || (!paramorb.a()));
      a(anni.a(2131698744));
      paramorb.jdField_a_of_type_Int = 1;
      paramorb = this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetImageView;
    } while (paramorb == null);
    if (b())
    {
      paramorb.setVisibility(8);
      return;
    }
    paramorb.setVisibility(0);
    paramorb.setImageResource(2130842679);
  }
  
  public void b(orb paramorb, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, paramorb, paramInt));
      do
      {
        return;
      } while ((paramorb == null) || (paramorb.jdField_a_of_type_Int != 3));
      localObject = this.jdField_a_of_type_Rxl.e;
      localProgressBar = this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetProgressBar;
      localImageView = this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetImageView;
    } while ((localObject == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    Object localObject = anni.a(2131698740) + paramInt + "%";
    opr.a(this.jdField_a_of_type_Rxl.e, (String)localObject);
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (a())
    {
      opr.a(this.jdField_a_of_type_Rxl.l, (String)localObject);
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    paramorb.b = paramInt;
  }
  
  public void c(DownloadInfo paramDownloadInfo, orb paramorb)
  {
    if (a(paramDownloadInfo, paramorb)) {
      d(paramorb);
    }
  }
  
  public void c(String paramString1, String paramString2, orb paramorb) {}
  
  public void c(orb paramorb)
  {
    if (paramorb == null) {}
    ImageView localImageView;
    do
    {
      ProgressBar localProgressBar;
      do
      {
        return;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, paramorb));
          return;
        }
        localProgressBar = this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rxl.jdField_c_of_type_AndroidWidgetImageView;
      } while ((localProgressBar == null) || (paramorb == null) || (!paramorb.a()));
      a(anni.a(2131698732));
      localProgressBar.setProgress(100);
      if (a()) {
        this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
      paramorb.b = 100;
      paramorb.jdField_a_of_type_Int = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842679);
  }
  
  public void d(DownloadInfo paramDownloadInfo, orb paramorb)
  {
    if (a(paramDownloadInfo, paramorb)) {
      c(paramorb);
    }
  }
  
  public void d(orb paramorb)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this, paramorb));
    }
    TextView localTextView;
    do
    {
      return;
      localTextView = this.jdField_a_of_type_Rxl.e;
    } while ((localTextView == null) || (paramorb == null));
    localTextView.setText(anni.a(2131698734));
    if (a()) {
      this.jdField_a_of_type_Rxl.l.setText(anni.a(2131698739));
    }
    paramorb.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ore
 * JD-Core Version:    0.7.0.1
 */