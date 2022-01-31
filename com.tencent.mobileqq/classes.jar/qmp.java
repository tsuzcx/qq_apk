import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;
import mqq.os.MqqHandler;

public class qmp
  extends qmk
  implements qms
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getContext());
  private final String jdField_a_of_type_JavaLangString = "ReadInjoyPlayer<" + Integer.toHexString(hashCode()) + ">";
  public qmr a;
  private String b;
  private String c;
  
  public qmp(int paramInt)
  {
    super(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_Qmr = new qmr(paramInt, this);
    a(this.jdField_a_of_type_Qmr);
  }
  
  private void a(String paramString, long paramLong)
  {
    if (paramString == null) {
      return;
    }
    if (ViolaUtils.isUiThread())
    {
      a(paramString, 2, paramLong);
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInjoyPlayer.3(this, paramString, paramLong));
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, 2, paramLong, paramInt);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(this.b);
    boolean bool2 = TextUtils.isEmpty(this.c);
    int i;
    int j;
    if ((!bool1) || (!bool2))
    {
      i = 1;
      if ((!bool1) && (!this.b.equals(paramString1))) {
        break label89;
      }
      j = 1;
      label49:
      if ((!bool2) && (!this.c.equals(paramString2))) {
        break label95;
      }
    }
    label89:
    label95:
    for (int k = 1;; k = 0)
    {
      if ((i == 0) || (j == 0) || (k == 0)) {
        break label101;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label49;
    }
    label101:
    return false;
  }
  
  private void b(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    ocm.a().a(paramString, "PubAccountArticleCenter.GetUrlByVid", new qmq(this, paramString, paramLong, paramInt));
  }
  
  private void c(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, paramString, 2, paramLong, paramInt);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByBusiType: vid=" + paramString1 + ", url=" + paramString2 + ", busiType=" + paramInt1);
    }
    ThreadManager.excute(new ReadInjoyPlayer.1(this, paramInt1, paramString1, paramLong, paramInt2, paramString2), 16, null, true);
  }
  
  public void a(pqb parampqb)
  {
    parampqb.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    parampqb.i = b();
    parampqb.j = c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmp
 * JD-Core Version:    0.7.0.1
 */