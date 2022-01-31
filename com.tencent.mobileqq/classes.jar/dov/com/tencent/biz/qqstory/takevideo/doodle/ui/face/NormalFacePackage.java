package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import ankj;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NormalFacePackage
  extends FacePackage
{
  public final List a;
  public boolean b;
  public int c;
  public int d;
  public String f;
  public String g;
  
  public NormalFacePackage(@NonNull String paramString)
  {
    super(paramString);
    this.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((NormalFacePackage.PackageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if ((!StringUtil.a(paramString)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        NormalFacePackage.PackageInfo localPackageInfo = (NormalFacePackage.PackageInfo)localIterator.next();
        if (paramString.equals(localPackageInfo.jdField_a_of_type_JavaLangString)) {
          return localPackageInfo.jdField_a_of_type_Int;
        }
      }
    }
    return 0;
  }
  
  public String a()
  {
    return "NormalFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((NormalFacePackage.PackageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if ((!StringUtil.a(paramString)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        NormalFacePackage.PackageInfo localPackageInfo = (NormalFacePackage.PackageInfo)localIterator.next();
        if (paramString.equals(localPackageInfo.jdField_a_of_type_JavaLangString)) {
          return localPackageInfo.b;
        }
      }
    }
    return null;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(this.g)) {}
    Object localObject;
    do
    {
      return null;
      localObject = new File(this.g);
    } while (!((File)localObject).exists());
    int j;
    File localFile1;
    if (((File)localObject).isDirectory())
    {
      File[] arrayOfFile = ((File)localObject).listFiles(new ankj(this));
      if (arrayOfFile != null)
      {
        int k = arrayOfFile.length;
        j = 0;
        if (j < k)
        {
          localFile1 = arrayOfFile[j];
          if (this.jdField_a_of_type_JavaUtilList.size() < 100) {
            break label104;
          }
        }
      }
    }
    return localArrayList;
    label104:
    String str = localFile1.getName();
    int i;
    if (str.endsWith(".apng")) {
      i = 1;
    }
    for (;;)
    {
      label123:
      File localFile2;
      if (i == 1)
      {
        localObject = localFile1.getAbsolutePath();
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 5) + ".bpng";
        localFile2 = new File((String)localObject);
        if ((!localFile2.isFile()) || (!localFile2.exists())) {}
      }
      for (localObject = localFile2.toURI().toString();; localObject = null)
      {
        localArrayList.add(new NormalFacePackage.PackageInfo(str, localFile1.toURI().toString(), i, (String)localObject));
        j += 1;
        break;
        if (!str.endsWith(".gif")) {
          break label293;
        }
        i = 2;
        break label123;
        if (QLog.isColorLevel()) {
          QLog.d("FacePackage", 2, "dynamicStatic thumbFile not exist " + (String)localObject);
        }
      }
      label293:
      i = 0;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((NormalFacePackage.PackageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_c_of_type_JavaLangString;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NormalFacePackage{");
    localStringBuffer.append("id='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append("logoUrl='").append(this.jdField_c_of_type_JavaLangString).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).append('\'');
    localStringBuffer.append(", zipDownloadUrl='").append(this.f).append('\'');
    localStringBuffer.append(", facePkgPath='").append(this.g).append('\'');
    localStringBuffer.append(", isDownloading=").append(this.b);
    localStringBuffer.append(", maxProgress=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", currentProgress=").append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage
 * JD-Core Version:    0.7.0.1
 */