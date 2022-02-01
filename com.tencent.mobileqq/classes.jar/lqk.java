import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.model.SizeI;
import com.tencent.util.Pair;
import java.io.File;
import java.util.List;

public class lqk
{
  private final int jdField_a_of_type_Int;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private lqh jdField_a_of_type_Lqh;
  private lqm jdField_a_of_type_Lqm;
  private lqp jdField_a_of_type_Lqp;
  private final int jdField_b_of_type_Int;
  private lqp jdField_b_of_type_Lqp;
  
  public lqk(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Lqm = new lqm();
    this.jdField_a_of_type_Lqm.a(new lql(this));
    this.jdField_a_of_type_Lqm.d();
    this.jdField_a_of_type_Lqh = new lqh(paramInt1, paramInt2);
    this.jdField_a_of_type_Lqm.a(this.jdField_a_of_type_Lqh);
  }
  
  private lqp a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    lqo locallqo = new lqo(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: create filter#" + Integer.toHexString(locallqo.hashCode()));
    locallqo.a(paramString);
    return locallqo;
  }
  
  private void a(List<lqn> paramList)
  {
    if ((this.jdField_a_of_type_Lqp == null) || (!(this.jdField_a_of_type_Lqp instanceof lqo))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((lqo)this.jdField_a_of_type_Lqp).a();
      f1 = this.jdField_a_of_type_Int / ((SizeI)localObject).width;
      localObject = ((lqo)this.jdField_a_of_type_Lqp).a();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    lqn locallqn;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      locallqn = (lqn)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + locallqn.jdField_b_of_type_Int + ", " + locallqn.c + "), (" + locallqn.d + ", " + locallqn.e + ")");
      }
      if ((locallqn.jdField_a_of_type_JavaUtilList != null) && (locallqn.e != 0) && (locallqn.d != 0)) {
        break label234;
      }
    }
    for (;;)
    {
      i += 1;
      break label74;
      break;
      label234:
      int j = 0;
      while (j < locallqn.jdField_a_of_type_JavaUtilList.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / locallqn.d, ((RectF)localPair.first).height() / locallqn.e);
        locallqn.jdField_a_of_type_JavaUtilList.set(j, lqj.a((TTFaceOriginDataModel)locallqn.jdField_a_of_type_JavaUtilList.get(j), new RectF(0.0F, 0.0F, locallqn.d, locallqn.e), (RectF)localPair.first, (Matrix)localPair.second, f1, locallqn.jdField_a_of_type_Boolean));
        locallqn.d = ((int)(locallqn.d * f2));
        locallqn.e = ((int)(locallqn.e * f2));
        j += 1;
      }
      if (locallqn.jdField_a_of_type_Boolean)
      {
        j = 0;
        while (j < locallqn.jdField_a_of_type_JavaUtilList.size())
        {
          lqj.a((TTFaceOriginDataModel)locallqn.jdField_a_of_type_JavaUtilList.get(j));
          j += 1;
        }
      }
    }
  }
  
  private lqp b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    lqg locallqg = new lqg();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: create filter#" + Integer.toHexString(locallqg.hashCode()));
    locallqg.a(paramString);
    return locallqg;
  }
  
  public Frame a(List<lqn> paramList, long paramLong)
  {
    a(paramList);
    this.jdField_a_of_type_Lqm.a(paramList, paramLong);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    return paramList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: ");
    if (this.jdField_a_of_type_Lqm != null)
    {
      this.jdField_a_of_type_Lqm.e();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_Lqm.hashCode()));
      this.jdField_a_of_type_Lqm = null;
    }
    if (this.jdField_a_of_type_Lqh != null)
    {
      this.jdField_a_of_type_Lqh.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lqh.hashCode()));
      this.jdField_a_of_type_Lqh = null;
    }
    if (this.jdField_a_of_type_Lqp != null)
    {
      this.jdField_a_of_type_Lqp.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lqp.hashCode()));
      this.jdField_a_of_type_Lqp = null;
    }
    if (this.jdField_b_of_type_Lqp != null)
    {
      this.jdField_b_of_type_Lqp.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Lqp.hashCode()));
      this.jdField_b_of_type_Lqp = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString);
    lqp locallqp = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = locallqp;
    if (locallqp == null) {
      localObject = this.jdField_a_of_type_Lqh;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_Lqm.c();
    if ((this.jdField_a_of_type_Lqp != null) && (this.jdField_a_of_type_Lqp != this.jdField_a_of_type_Lqh))
    {
      this.jdField_a_of_type_Lqp.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_Lqp.hashCode()));
    }
    this.jdField_a_of_type_Lqm.a((lqp)localObject);
    this.jdField_a_of_type_Lqp = ((lqp)localObject);
    if (this.jdField_b_of_type_Lqp != null)
    {
      this.jdField_b_of_type_Lqp.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_Lqp.hashCode()));
    }
    if (paramString != null) {
      ((lqp)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_Lqp = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqk
 * JD-Core Version:    0.7.0.1
 */