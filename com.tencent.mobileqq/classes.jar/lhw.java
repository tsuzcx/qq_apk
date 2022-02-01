import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.1;
import com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.2;
import com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.3;
import com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.4;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;

public class lhw
  implements lhv
{
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  boolean jdField_a_of_type_Boolean;
  
  public lhw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = paramContext.getSharedPreferences("effects_face_file", 4).getBoolean("key_frist_use_Face" + VideoController.a().a().getCurrentAccountUin(), false);
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.MOUTH_OPEN.value, 2131694860);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value, 2131694858);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.BLINK.value, 2131694857);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.HEAD_SHAKE.value, 2131694861);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(PTFaceAttr.PTExpression.KISS.value, 2131694859);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(100, 2131694848);
  }
  
  public String a(Context paramContext, int paramInt)
  {
    Integer localInteger = Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt));
    if (localInteger.intValue() > 0) {
      return paramContext.getResources().getString(localInteger.intValue());
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EffectPendantTipsImpl.3(this, paramInt));
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EffectPendantTipsImpl.2(this, paramString, paramDrawable));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EffectPendantTipsImpl.1(this, paramString));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EffectPendantTipsImpl.4(this), paramInt);
  }
  
  public void c(int paramInt)
  {
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhw
 * JD-Core Version:    0.7.0.1
 */