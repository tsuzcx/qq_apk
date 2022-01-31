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

public class lgl
{
  private final int jdField_a_of_type_Int;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private lgi jdField_a_of_type_Lgi;
  private lgn jdField_a_of_type_Lgn;
  private lgq jdField_a_of_type_Lgq;
  private final int jdField_b_of_type_Int;
  private lgq jdField_b_of_type_Lgq;
  
  public lgl(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Lgn = new lgn();
    this.jdField_a_of_type_Lgn.a(new lgm(this));
    this.jdField_a_of_type_Lgn.d();
    this.jdField_a_of_type_Lgi = new lgi(paramInt1, paramInt2);
    this.jdField_a_of_type_Lgn.a(this.jdField_a_of_type_Lgi);
  }
  
  private lgq a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    lgp locallgp = new lgp(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: create filter#" + Integer.toHexString(locallgp.hashCode()));
    locallgp.a(paramString);
    return locallgp;
  }
  
  private void a(List<lgo> paramList)
  {
    if ((this.jdField_a_of_type_Lgq == null) || (!(this.jdField_a_of_type_Lgq instanceof lgp))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((lgp)this.jdField_a_of_type_Lgq).a();
      f1 = this.jdField_a_of_type_Int / ((SizeI)localObject).width;
      localObject = ((lgp)this.jdField_a_of_type_Lgq).a();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    lgo locallgo;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      locallgo = (lgo)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + locallgo.jdField_b_of_type_Int + ", " + locallgo.c + "), (" + locallgo.d + ", " + locallgo.e + ")");
      }
      if ((locallgo.jdField_a_of_type_JavaUtilList != null) && (locallgo.e != 0) && (locallgo.d != 0)) {
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
      while (j < locallgo.jdField_a_of_type_JavaUtilList.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / locallgo.d, ((RectF)localPair.first).height() / locallgo.e);
        locallgo.jdField_a_of_type_JavaUtilList.set(j, lgk.a((TTFaceOriginDataModel)locallgo.jdField_a_of_type_JavaUtilList.get(j), new RectF(0.0F, 0.0F, locallgo.d, locallgo.e), (RectF)localPair.first, (Matrix)localPair.second, f1, locallgo.jdField_a_of_type_Boolean));
        locallgo.d = ((int)(locallgo.d * f2));
        locallgo.e = ((int)(locallgo.e * f2));
        j += 1;
      }
      if (locallgo.jdField_a_of_type_Boolean)
      {
        j = 0;
        while (j < locallgo.jdField_a_of_type_JavaUtilList.size())
        {
          lgk.a((TTFaceOriginDataModel)locallgo.jdField_a_of_type_JavaUtilList.get(j));
          j += 1;
        }
      }
    }
  }
  
  private lgq b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    lgh locallgh = new lgh();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: create filter#" + Integer.toHexString(locallgh.hashCode()));
    locallgh.a(paramString);
    return locallgh;
  }
  
  public Frame a(List<lgo> paramList, long paramLong)
  {
    a(paramList);
    this.jdField_a_of_type_Lgn.a(paramList, paramLong);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    return paramList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: ");
    if (this.jdField_a_of_type_Lgn != null)
    {
      this.jdField_a_of_type_Lgn.e();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_Lgn.hashCode()));
      this.jdField_a_of_type_Lgn = null;
    }
    if (this.jdField_a_of_type_Lgi != null)
    {
      this.jdField_a_of_type_Lgi.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lgi.hashCode()));
      this.jdField_a_of_type_Lgi = null;
    }
    if (this.jdField_a_of_type_Lgq != null)
    {
      this.jdField_a_of_type_Lgq.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Lgq.hashCode()));
      this.jdField_a_of_type_Lgq = null;
    }
    if (this.jdField_b_of_type_Lgq != null)
    {
      this.jdField_b_of_type_Lgq.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Lgq.hashCode()));
      this.jdField_b_of_type_Lgq = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString);
    lgq locallgq = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = locallgq;
    if (locallgq == null) {
      localObject = this.jdField_a_of_type_Lgi;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_Lgn.c();
    if ((this.jdField_a_of_type_Lgq != null) && (this.jdField_a_of_type_Lgq != this.jdField_a_of_type_Lgi))
    {
      this.jdField_a_of_type_Lgq.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_Lgq.hashCode()));
    }
    this.jdField_a_of_type_Lgn.a((lgq)localObject);
    this.jdField_a_of_type_Lgq = ((lgq)localObject);
    if (this.jdField_b_of_type_Lgq != null)
    {
      this.jdField_b_of_type_Lgq.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_Lgq.hashCode()));
    }
    if (paramString != null) {
      ((lgq)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_Lgq = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgl
 * JD-Core Version:    0.7.0.1
 */