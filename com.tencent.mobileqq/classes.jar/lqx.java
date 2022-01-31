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

public class lqx
{
  private final int jdField_a_of_type_Int;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private lqu jdField_a_of_type_Lqu;
  private lqz jdField_a_of_type_Lqz;
  private lrc jdField_a_of_type_Lrc;
  private final int jdField_b_of_type_Int;
  private lrc jdField_b_of_type_Lrc;
  
  public lqx(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Lqz = new lqz();
    this.jdField_a_of_type_Lqz.a(new lqy(this));
    this.jdField_a_of_type_Lqz.d();
    this.jdField_a_of_type_Lqu = new lqu(paramInt1, paramInt2);
    this.jdField_a_of_type_Lqz.a(this.jdField_a_of_type_Lqu);
  }
  
  private lrc a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    lrb locallrb = new lrb(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: create filter#" + Integer.toHexString(locallrb.hashCode()));
    locallrb.a(paramString);
    return locallrb;
  }
  
  private void a(List<lra> paramList)
  {
    if ((this.jdField_a_of_type_Lrc == null) || (!(this.jdField_a_of_type_Lrc instanceof lrb))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((lrb)this.jdField_a_of_type_Lrc).a();
      f1 = this.jdField_a_of_type_Int / ((SizeI)localObject).width;
      localObject = ((lrb)this.jdField_a_of_type_Lrc).a();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    lra locallra;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      locallra = (lra)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + locallra.jdField_b_of_type_Int + ", " + locallra.c + "), (" + locallra.d + ", " + locallra.e + ")");
      }
      if ((locallra.jdField_a_of_type_JavaUtilList != null) && (locallra.e != 0) && (locallra.d != 0)) {
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
      while (j < locallra.jdField_a_of_type_JavaUtilList.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / locallra.d, ((RectF)localPair.first).height() / locallra.e);
        locallra.jdField_a_of_type_JavaUtilList.set(j, lqw.a((TTFaceOriginDataModel)locallra.jdField_a_of_type_JavaUtilList.get(j), new RectF(0.0F, 0.0F, locallra.d, locallra.e), (RectF)localPair.first, (Matrix)localPair.second, f1, locallra.jdField_a_of_type_Boolean));
        locallra.d = ((int)(locallra.d * f2));
        locallra.e = ((int)(locallra.e * f2));
        j += 1;
      }
      if (locallra.jdField_a_of_type_Boolean)
      {
        j = 0;
        while (j < locallra.jdField_a_of_type_JavaUtilList.size())
        {
          lqw.a((TTFaceOriginDataModel)locallra.jdField_a_of_type_JavaUtilList.get(j));
          j += 1;
        }
      }
    }
  }
  
  private lrc b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    lqt locallqt = new lqt();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: create filter#" + Integer.toHexString(locallqt.hashCode()));
    locallqt.a(paramString);
    return locallqt;
  }
  
  public Frame a(List<lra> paramList, long paramLong)
  {
    a(paramList);
    this.jdField_a_of_type_Lqz.a(paramList, paramLong);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    return paramList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: ");
    if (this.jdField_a_of_type_Lqz != null)
    {
      this.jdField_a_of_type_Lqz.e();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_Lqz.hashCode()));
      this.jdField_a_of_type_Lqz = null;
    }
    if (this.jdField_a_of_type_Lqu != null)
    {
      this.jdField_a_of_type_Lqu.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lqu.hashCode()));
      this.jdField_a_of_type_Lqu = null;
    }
    if (this.jdField_a_of_type_Lrc != null)
    {
      this.jdField_a_of_type_Lrc.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lrc.hashCode()));
      this.jdField_a_of_type_Lrc = null;
    }
    if (this.jdField_b_of_type_Lrc != null)
    {
      this.jdField_b_of_type_Lrc.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Lrc.hashCode()));
      this.jdField_b_of_type_Lrc = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString);
    lrc locallrc = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = locallrc;
    if (locallrc == null) {
      localObject = this.jdField_a_of_type_Lqu;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_Lqz.c();
    if ((this.jdField_a_of_type_Lrc != null) && (this.jdField_a_of_type_Lrc != this.jdField_a_of_type_Lqu))
    {
      this.jdField_a_of_type_Lrc.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_Lrc.hashCode()));
    }
    this.jdField_a_of_type_Lqz.a((lrc)localObject);
    this.jdField_a_of_type_Lrc = ((lrc)localObject);
    if (this.jdField_b_of_type_Lrc != null)
    {
      this.jdField_b_of_type_Lrc.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_Lrc.hashCode()));
    }
    if (paramString != null) {
      ((lrc)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_Lrc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqx
 * JD-Core Version:    0.7.0.1
 */