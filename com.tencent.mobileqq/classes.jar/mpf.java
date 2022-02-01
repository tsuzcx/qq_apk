import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.GamePlayView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mpf
{
  Context jdField_a_of_type_AndroidContentContext;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  ZimuView jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
  lir jdField_a_of_type_Lir = null;
  lix jdField_a_of_type_Lix = null;
  
  public mpf(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private boolean a(long paramLong, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.h();
      paramViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView);
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
      return true;
    }
    if (this.jdField_a_of_type_Lir != null)
    {
      this.jdField_a_of_type_Lir.b();
      liu localliu = this.jdField_a_of_type_Lir.a();
      if (localliu != null) {
        paramViewGroup.removeView((View)localliu);
      }
      this.jdField_a_of_type_Lir = null;
      return true;
    }
    return false;
  }
  
  private boolean a(long paramLong, ViewGroup paramViewGroup, String paramString)
  {
    this.jdField_a_of_type_Lir = null;
    this.jdField_a_of_type_Lir = liv.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    paramString = (GamePlayView)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559703, null);
    if (this.jdField_a_of_type_Lir == null)
    {
      QLog.w("ZimuViewProxy", 1, "creatARZimuTask, fail");
      return false;
    }
    int i = this.jdField_a_of_type_Lir.a();
    String str = this.jdField_a_of_type_Lir.c();
    paramString.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_AndroidContentContext, str, i);
    this.jdField_a_of_type_Lir.a(paramString);
    paramViewGroup.addView(paramString);
    this.jdField_a_of_type_Lir.a();
    return true;
  }
  
  private boolean c(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = mpc.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    float f1;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      f1 = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a();
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)f1);
      if (!paramString.equals("film")) {
        break label121;
      }
      f1 = paramInt2 - localResources.getDimension(2131297661);
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      localLayoutParams.setMargins(0, (int)f2, 0, (int)f1);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView, localLayoutParams);
      if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView == null) {
        break;
      }
      return true;
      label121:
      f2 = paramInt1;
      f1 = 0.0F;
    }
    return false;
  }
  
  public ZimuItem a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      a();
      return (ZimuItem)this.jdField_a_of_type_Lix.a();
    }
    return null;
  }
  
  public lix a()
  {
    if (this.jdField_a_of_type_Lix == null) {
      this.jdField_a_of_type_Lix = ((lix)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    }
    return this.jdField_a_of_type_Lix;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = (ZimuItem)((lix)localObject).a();
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            new mcz(AudioHelper.b(), "maybeShowZimu", 1, (String)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    a(false);
    if (this.jdField_a_of_type_Lir != null)
    {
      this.jdField_a_of_type_Lix.a(paramLong, null);
      this.jdField_a_of_type_Lix.a("DisableARZimu", paramLong);
      this.jdField_a_of_type_Lir.b();
      this.jdField_a_of_type_Lir = null;
    }
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    Resources localResources;
    float f;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.getLayoutParams();
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a().equals("film")) {
        break label110;
      }
      if (!paramVideoLayerUI.i()) {
        break label91;
      }
      f = paramVideoLayerUI.c() - mjk.b(paramVideoLayerUI.b());
      localLayoutParams.bottomMargin = ((int)(localResources.getDimension(2131297557) + f));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.setLayoutParams(localLayoutParams);
      return;
      label91:
      localLayoutParams.bottomMargin = ((int)(paramInt2 - localResources.getDimension(2131297661)));
      continue;
      label110:
      f = paramInt1;
      localLayoutParams.topMargin = ((int)(localResources.getDimension(2131297675) + f));
    }
  }
  
  public void a(lgi paramlgi)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a(paramlgi);
    }
    while (this.jdField_a_of_type_Lir == null) {
      return;
    }
    this.jdField_a_of_type_Lir.a(paramlgi);
  }
  
  public void a(boolean paramBoolean)
  {
    a();
    liw.a(paramBoolean);
    this.jdField_a_of_type_Lix.a(paramBoolean);
  }
  
  public boolean a(long paramLong, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ZimuViewProxy", 1, "hideZimuView, exchangeItem[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    a();
    if (paramBoolean) {
      this.jdField_a_of_type_Lix.a(paramLong, null);
    }
    return a(paramLong, paramViewGroup);
  }
  
  public boolean a(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lir != null) {
      a(paramLong, paramViewGroup);
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView == null) {
      return c(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    if (!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a().equals(paramString))
    {
      a(paramLong, paramViewGroup);
      return c(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ZimuViewProxy", 1, "stopZimuView, seq[" + paramLong + "]");
    }
    a();
    a(paramLong, paramViewGroup);
    this.jdField_a_of_type_Lix.a(paramLong, null);
    this.jdField_a_of_type_Lix.a("stopZimuView", paramLong);
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a(paramBoolean);
    }
    if (this.jdField_a_of_type_Lir != null) {
      this.jdField_a_of_type_Lir.b();
    }
  }
  
  public boolean b(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      a(paramLong, paramViewGroup);
    }
    if (!liw.a()) {
      return false;
    }
    if (this.jdField_a_of_type_Lir == null) {
      return a(paramLong, paramViewGroup, paramString);
    }
    a(paramLong, paramViewGroup);
    return a(paramLong, paramViewGroup, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpf
 * JD-Core Version:    0.7.0.1
 */