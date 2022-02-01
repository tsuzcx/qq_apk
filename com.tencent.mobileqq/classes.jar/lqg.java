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

public class lqg
{
  private final int jdField_a_of_type_Int;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private lqd jdField_a_of_type_Lqd;
  private lqi jdField_a_of_type_Lqi;
  private lql jdField_a_of_type_Lql;
  private final int jdField_b_of_type_Int;
  private lql jdField_b_of_type_Lql;
  
  public lqg(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Lqi = new lqi();
    this.jdField_a_of_type_Lqi.a(new lqh(this));
    this.jdField_a_of_type_Lqi.d();
    this.jdField_a_of_type_Lqd = new lqd(paramInt1, paramInt2);
    this.jdField_a_of_type_Lqi.a(this.jdField_a_of_type_Lqd);
  }
  
  private lql a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    lqk locallqk = new lqk(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: create filter#" + Integer.toHexString(locallqk.hashCode()));
    locallqk.a(paramString);
    return locallqk;
  }
  
  private void a(List<lqj> paramList)
  {
    if ((this.jdField_a_of_type_Lql == null) || (!(this.jdField_a_of_type_Lql instanceof lqk))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((lqk)this.jdField_a_of_type_Lql).a();
      f1 = this.jdField_a_of_type_Int / ((SizeI)localObject).width;
      localObject = ((lqk)this.jdField_a_of_type_Lql).a();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    lqj locallqj;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      locallqj = (lqj)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + locallqj.jdField_b_of_type_Int + ", " + locallqj.c + "), (" + locallqj.d + ", " + locallqj.e + ")");
      }
      if ((locallqj.jdField_a_of_type_JavaUtilList != null) && (locallqj.e != 0) && (locallqj.d != 0)) {
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
      while (j < locallqj.jdField_a_of_type_JavaUtilList.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / locallqj.d, ((RectF)localPair.first).height() / locallqj.e);
        locallqj.jdField_a_of_type_JavaUtilList.set(j, lqf.a((TTFaceOriginDataModel)locallqj.jdField_a_of_type_JavaUtilList.get(j), new RectF(0.0F, 0.0F, locallqj.d, locallqj.e), (RectF)localPair.first, (Matrix)localPair.second, f1, locallqj.jdField_a_of_type_Boolean));
        locallqj.d = ((int)(locallqj.d * f2));
        locallqj.e = ((int)(locallqj.e * f2));
        j += 1;
      }
      if (locallqj.jdField_a_of_type_Boolean)
      {
        j = 0;
        while (j < locallqj.jdField_a_of_type_JavaUtilList.size())
        {
          lqf.a((TTFaceOriginDataModel)locallqj.jdField_a_of_type_JavaUtilList.get(j));
          j += 1;
        }
      }
    }
  }
  
  private lql b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    lqc locallqc = new lqc();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: create filter#" + Integer.toHexString(locallqc.hashCode()));
    locallqc.a(paramString);
    return locallqc;
  }
  
  public Frame a(List<lqj> paramList, long paramLong)
  {
    a(paramList);
    this.jdField_a_of_type_Lqi.a(paramList, paramLong);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    return paramList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: ");
    if (this.jdField_a_of_type_Lqi != null)
    {
      this.jdField_a_of_type_Lqi.e();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_Lqi.hashCode()));
      this.jdField_a_of_type_Lqi = null;
    }
    if (this.jdField_a_of_type_Lqd != null)
    {
      this.jdField_a_of_type_Lqd.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lqd.hashCode()));
      this.jdField_a_of_type_Lqd = null;
    }
    if (this.jdField_a_of_type_Lql != null)
    {
      this.jdField_a_of_type_Lql.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lql.hashCode()));
      this.jdField_a_of_type_Lql = null;
    }
    if (this.jdField_b_of_type_Lql != null)
    {
      this.jdField_b_of_type_Lql.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Lql.hashCode()));
      this.jdField_b_of_type_Lql = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString);
    lql locallql = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = locallql;
    if (locallql == null) {
      localObject = this.jdField_a_of_type_Lqd;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_Lqi.c();
    if ((this.jdField_a_of_type_Lql != null) && (this.jdField_a_of_type_Lql != this.jdField_a_of_type_Lqd))
    {
      this.jdField_a_of_type_Lql.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_Lql.hashCode()));
    }
    this.jdField_a_of_type_Lqi.a((lql)localObject);
    this.jdField_a_of_type_Lql = ((lql)localObject);
    if (this.jdField_b_of_type_Lql != null)
    {
      this.jdField_b_of_type_Lql.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_Lql.hashCode()));
    }
    if (paramString != null) {
      ((lql)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_Lql = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqg
 * JD-Core Version:    0.7.0.1
 */