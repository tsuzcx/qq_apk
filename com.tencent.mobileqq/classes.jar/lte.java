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

public class lte
{
  private final int jdField_a_of_type_Int;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private ltb jdField_a_of_type_Ltb;
  private ltg jdField_a_of_type_Ltg;
  private ltj jdField_a_of_type_Ltj;
  private final int jdField_b_of_type_Int;
  private ltj jdField_b_of_type_Ltj;
  
  public lte(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ltg = new ltg();
    this.jdField_a_of_type_Ltg.a(new ltf(this));
    this.jdField_a_of_type_Ltg.d();
    this.jdField_a_of_type_Ltb = new ltb(paramInt1, paramInt2);
    this.jdField_a_of_type_Ltg.a(this.jdField_a_of_type_Ltb);
  }
  
  private ltj a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    lti locallti = new lti(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: create filter#" + Integer.toHexString(locallti.hashCode()));
    locallti.a(paramString);
    return locallti;
  }
  
  private void a(List<lth> paramList)
  {
    if ((this.jdField_a_of_type_Ltj == null) || (!(this.jdField_a_of_type_Ltj instanceof lti))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((lti)this.jdField_a_of_type_Ltj).a();
      f1 = this.jdField_a_of_type_Int / ((SizeI)localObject).width;
      localObject = ((lti)this.jdField_a_of_type_Ltj).a();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    lth locallth;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      locallth = (lth)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + locallth.jdField_b_of_type_Int + ", " + locallth.c + "), (" + locallth.d + ", " + locallth.e + ")");
      }
      if ((locallth.jdField_a_of_type_JavaUtilList != null) && (locallth.e != 0) && (locallth.d != 0)) {
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
      while (j < locallth.jdField_a_of_type_JavaUtilList.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / locallth.d, ((RectF)localPair.first).height() / locallth.e);
        locallth.jdField_a_of_type_JavaUtilList.set(j, ltd.a((TTFaceOriginDataModel)locallth.jdField_a_of_type_JavaUtilList.get(j), new RectF(0.0F, 0.0F, locallth.d, locallth.e), (RectF)localPair.first, (Matrix)localPair.second, f1, locallth.jdField_a_of_type_Boolean));
        locallth.d = ((int)(locallth.d * f2));
        locallth.e = ((int)(locallth.e * f2));
        j += 1;
      }
      if (locallth.jdField_a_of_type_Boolean)
      {
        j = 0;
        while (j < locallth.jdField_a_of_type_JavaUtilList.size())
        {
          ltd.a((TTFaceOriginDataModel)locallth.jdField_a_of_type_JavaUtilList.get(j));
          j += 1;
        }
      }
    }
  }
  
  private ltj b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    lta locallta = new lta();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: create filter#" + Integer.toHexString(locallta.hashCode()));
    locallta.a(paramString);
    return locallta;
  }
  
  public Frame a(List<lth> paramList, long paramLong)
  {
    a(paramList);
    this.jdField_a_of_type_Ltg.a(paramList, paramLong);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    return paramList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: ");
    if (this.jdField_a_of_type_Ltg != null)
    {
      this.jdField_a_of_type_Ltg.e();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_Ltg.hashCode()));
      this.jdField_a_of_type_Ltg = null;
    }
    if (this.jdField_a_of_type_Ltb != null)
    {
      this.jdField_a_of_type_Ltb.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Ltb.hashCode()));
      this.jdField_a_of_type_Ltb = null;
    }
    if (this.jdField_a_of_type_Ltj != null)
    {
      this.jdField_a_of_type_Ltj.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Ltj.hashCode()));
      this.jdField_a_of_type_Ltj = null;
    }
    if (this.jdField_b_of_type_Ltj != null)
    {
      this.jdField_b_of_type_Ltj.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Ltj.hashCode()));
      this.jdField_b_of_type_Ltj = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString);
    ltj localltj = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = localltj;
    if (localltj == null) {
      localObject = this.jdField_a_of_type_Ltb;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_Ltg.c();
    if ((this.jdField_a_of_type_Ltj != null) && (this.jdField_a_of_type_Ltj != this.jdField_a_of_type_Ltb))
    {
      this.jdField_a_of_type_Ltj.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_Ltj.hashCode()));
    }
    this.jdField_a_of_type_Ltg.a((ltj)localObject);
    this.jdField_a_of_type_Ltj = ((ltj)localObject);
    if (this.jdField_b_of_type_Ltj != null)
    {
      this.jdField_b_of_type_Ltj.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_Ltj.hashCode()));
    }
    if (paramString != null) {
      ((ltj)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_Ltj = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lte
 * JD-Core Version:    0.7.0.1
 */