import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nre
{
  public String a;
  private List<ArrayList<nqw>> a;
  public nrb a;
  public boolean a;
  public String b;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public nre()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      QLog.d("GuessPictureGameResultMgr", 1, "generateVideoPhoto, gameImageDataCache is empty");
    }
    for (;;)
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)localIterator.next();
        if (!((nqw)localArrayList2.get(0)).jdField_a_of_type_Boolean) {
          localArrayList1.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.indexOf(localArrayList2)));
        }
      }
      if (localArrayList1.isEmpty()) {}
      for (int i = (int)(Math.random() * this.jdField_a_of_type_JavaUtilList.size()); !a((ArrayList)this.jdField_a_of_type_JavaUtilList.get(i)); i = ((Integer)localArrayList1.get((int)(Math.random() * localArrayList1.size()))).intValue())
      {
        this.jdField_b_of_type_JavaLangString = null;
        return;
      }
    }
  }
  
  private boolean a(ArrayList<nqw> paramArrayList)
  {
    if ((paramArrayList.isEmpty()) || (((nqw)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      QLog.d("GuessPictureGameResultMgr", 1, "generateVideoPhoto, selectImageData is empty");
      return false;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Nrb.a, this.jdField_a_of_type_Nrb.b, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      this.jdField_a_of_type_Nrb.a(localCanvas, (nqw)paramArrayList.get(0), false);
      if ((paramArrayList.size() > 1) && (((nqw)paramArrayList.get(1)).jdField_b_of_type_JavaLangString.equals("Tips"))) {
        this.jdField_a_of_type_Nrb.b(localCanvas, (nqw)paramArrayList.get(1), false);
      }
      bool = FileUtil.writeBitmapToFile(localBitmap, this.jdField_b_of_type_JavaLangString);
      try
      {
        localBitmap.recycle();
        QLog.d("GuessPictureGameResultMgr", 1, new Object[] { "generateVideoPhoto, ret:", Boolean.valueOf(bool) });
        return bool;
      }
      catch (Exception paramArrayList) {}
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    QLog.e("GuessPictureGameResultMgr", 1, "generateVideoPhoto fail", paramArrayList);
    return bool;
  }
  
  private void b(ArrayList<nqw> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        nqw localnqw = (nqw)paramArrayList.next();
        if ((!localnqw.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (!localnqw.jdField_b_of_type_JavaLangString.equals("Back Image"))) {
          localnqw.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, nrb paramnrb)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Nrb = paramnrb;
  }
  
  public void a(ArrayList<nqw> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      try
      {
        if (!paramArrayList.isEmpty())
        {
          localObject = ((nqw)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsBitmap;
          if (localObject != null) {}
        }
        else
        {
          return;
        }
        Object localObject = ((nqw)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
        if ((((String)localObject).equals("Mosaic Image")) || (((String)localObject).equals("Tips")))
        {
          if ((((String)localObject).equals("Mosaic Image")) && (this.c))
          {
            this.jdField_b_of_type_Boolean = false;
            this.c = false;
          }
          if (this.jdField_b_of_type_Boolean) {
            break label308;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(paramArrayList);
          i = 1;
          j = i;
          if (((String)localObject).equals("Tips"))
          {
            j = i;
            if (this.jdField_b_of_type_Boolean)
            {
              j = i;
              if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
              {
                b((ArrayList)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1));
                this.jdField_a_of_type_JavaUtilList.add(paramArrayList);
                j = 1;
              }
            }
          }
          if (!this.d)
          {
            this.d = true;
            a(paramArrayList);
          }
          if (j != 0) {
            continue;
          }
          b(paramArrayList);
          continue;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label303;
        }
      }
      finally {}
      if ((this.jdField_a_of_type_Nrb.b()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.c = true;
        ((nqw)((ArrayList)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).get(0)).jdField_a_of_type_Boolean = this.jdField_a_of_type_Nrb.a();
      }
      label303:
      int j = 0;
      continue;
      label308:
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.c = true;
        ((nqw)((ArrayList)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).get(0)).jdField_a_of_type_Boolean = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (!paramBoolean) {
      nfc.a().a().a(null, null, paramLong);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameResultMgr", 2, new Object[] { "saveResult, videoPath:", this.jdField_a_of_type_JavaLangString, " photoPath:", this.jdField_b_of_type_JavaLangString });
      }
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaLangString = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        b((ArrayList)localIterator.next());
      }
      a();
      nfc.a().a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramLong);
    }
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nre
 * JD-Core Version:    0.7.0.1
 */