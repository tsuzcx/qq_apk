import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.2;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class sgs
  extends sgn
  implements sgr, sgv
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final String jdField_a_of_type_JavaLangString = "ReadInjoyPlayer<" + Integer.toHexString(hashCode()) + ">";
  public sgu a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public sgs(int paramInt)
  {
    this(paramInt, null, false);
  }
  
  public sgs(int paramInt, String paramString, boolean paramBoolean)
  {
    super(BaseApplicationImpl.getContext(), paramString, paramBoolean);
    this.jdField_a_of_type_Sgu = new sgu(paramInt, this);
    a(this.jdField_a_of_type_Sgu);
    a(this);
  }
  
  private void a(String paramString, long paramLong)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, 1, paramLong);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, 101, paramLong, paramInt);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    boolean bool2 = TextUtils.isEmpty(this.c);
    int i;
    int j;
    if ((!bool1) || (!bool2))
    {
      i = 1;
      if ((!bool1) && (!this.jdField_b_of_type_JavaLangString.equals(paramString1))) {
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
    sjo.a().a(paramString, new sgt(this, paramString, paramLong, paramInt));
  }
  
  private void c(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, paramString, 101, paramLong, paramInt);
  }
  
  private void n() {}
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByBusiType: vid=" + paramString1 + ", url=" + paramString2 + ", busiType=" + paramInt1);
    }
    if (sgk.a(paramInt1))
    {
      a(paramString1, paramLong);
      return;
    }
    if ((paramInt1 == 2) || ((paramInt1 == 6) && (!TextUtils.isEmpty(paramString1))))
    {
      b(paramString1, paramLong, paramInt2);
      return;
    }
    if (paramInt1 == 5)
    {
      c(paramString1, paramLong, paramInt2);
      return;
    }
    a(paramString2, paramLong, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
    if (h()) {
      rwv.a(new ReadInjoyPlayer.2(this));
    }
  }
  
  public void a(rdt paramrdt)
  {
    paramrdt.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramrdt.j = b();
    paramrdt.k = c();
  }
  
  public void onBufferEnd() {}
  
  public void onBufferStart() {}
  
  public void onCompletion() {}
  
  public void onFirstFrameRendered() {}
  
  public void onProgressChanged(long paramLong)
  {
    rwv.a(new ReadInjoyPlayer.4(this));
  }
  
  public void onVideoEnd(int paramInt) {}
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onVideoOpen() {}
  
  public void onVideoPause() {}
  
  public void onVideoPrepared() {}
  
  public void onVideoRestart() {}
  
  public void onVideoStart() {}
  
  public void onVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgs
 * JD-Core Version:    0.7.0.1
 */