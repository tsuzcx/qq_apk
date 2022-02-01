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

public class lrc
{
  private final int jdField_a_of_type_Int;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private lqz jdField_a_of_type_Lqz;
  private lre jdField_a_of_type_Lre;
  private lrh jdField_a_of_type_Lrh;
  private final int jdField_b_of_type_Int;
  private lrh jdField_b_of_type_Lrh;
  
  public lrc(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Lre = new lre();
    this.jdField_a_of_type_Lre.a(new lrd(this));
    this.jdField_a_of_type_Lre.d();
    this.jdField_a_of_type_Lqz = new lqz(paramInt1, paramInt2);
    this.jdField_a_of_type_Lre.a(this.jdField_a_of_type_Lqz);
  }
  
  private lrh a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    lrg locallrg = new lrg(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: create filter#" + Integer.toHexString(locallrg.hashCode()));
    locallrg.a(paramString);
    return locallrg;
  }
  
  private void a(List<lrf> paramList)
  {
    if ((this.jdField_a_of_type_Lrh == null) || (!(this.jdField_a_of_type_Lrh instanceof lrg))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((lrg)this.jdField_a_of_type_Lrh).a();
      f1 = this.jdField_a_of_type_Int / ((SizeI)localObject).width;
      localObject = ((lrg)this.jdField_a_of_type_Lrh).a();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    lrf locallrf;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      locallrf = (lrf)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + locallrf.jdField_b_of_type_Int + ", " + locallrf.c + "), (" + locallrf.d + ", " + locallrf.e + ")");
      }
      if ((locallrf.jdField_a_of_type_JavaUtilList != null) && (locallrf.e != 0) && (locallrf.d != 0)) {
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
      while (j < locallrf.jdField_a_of_type_JavaUtilList.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / locallrf.d, ((RectF)localPair.first).height() / locallrf.e);
        locallrf.jdField_a_of_type_JavaUtilList.set(j, lrb.a((TTFaceOriginDataModel)locallrf.jdField_a_of_type_JavaUtilList.get(j), new RectF(0.0F, 0.0F, locallrf.d, locallrf.e), (RectF)localPair.first, (Matrix)localPair.second, f1, locallrf.jdField_a_of_type_Boolean));
        locallrf.d = ((int)(locallrf.d * f2));
        locallrf.e = ((int)(locallrf.e * f2));
        j += 1;
      }
      if (locallrf.jdField_a_of_type_Boolean)
      {
        j = 0;
        while (j < locallrf.jdField_a_of_type_JavaUtilList.size())
        {
          lrb.a((TTFaceOriginDataModel)locallrf.jdField_a_of_type_JavaUtilList.get(j));
          j += 1;
        }
      }
    }
  }
  
  private lrh b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    lqy locallqy = new lqy();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: create filter#" + Integer.toHexString(locallqy.hashCode()));
    locallqy.a(paramString);
    return locallqy;
  }
  
  public Frame a(List<lrf> paramList, long paramLong)
  {
    a(paramList);
    this.jdField_a_of_type_Lre.a(paramList, paramLong);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    return paramList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: ");
    if (this.jdField_a_of_type_Lre != null)
    {
      this.jdField_a_of_type_Lre.e();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_Lre.hashCode()));
      this.jdField_a_of_type_Lre = null;
    }
    if (this.jdField_a_of_type_Lqz != null)
    {
      this.jdField_a_of_type_Lqz.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lqz.hashCode()));
      this.jdField_a_of_type_Lqz = null;
    }
    if (this.jdField_a_of_type_Lrh != null)
    {
      this.jdField_a_of_type_Lrh.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lrh.hashCode()));
      this.jdField_a_of_type_Lrh = null;
    }
    if (this.jdField_b_of_type_Lrh != null)
    {
      this.jdField_b_of_type_Lrh.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Lrh.hashCode()));
      this.jdField_b_of_type_Lrh = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString);
    lrh locallrh = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = locallrh;
    if (locallrh == null) {
      localObject = this.jdField_a_of_type_Lqz;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_Lre.c();
    if ((this.jdField_a_of_type_Lrh != null) && (this.jdField_a_of_type_Lrh != this.jdField_a_of_type_Lqz))
    {
      this.jdField_a_of_type_Lrh.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_Lrh.hashCode()));
    }
    this.jdField_a_of_type_Lre.a((lrh)localObject);
    this.jdField_a_of_type_Lrh = ((lrh)localObject);
    if (this.jdField_b_of_type_Lrh != null)
    {
      this.jdField_b_of_type_Lrh.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_Lrh.hashCode()));
    }
    if (paramString != null) {
      ((lrh)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_Lrh = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrc
 * JD-Core Version:    0.7.0.1
 */