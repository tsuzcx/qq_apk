import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TargetApi(14)
public class svi
  extends sve
{
  protected int a;
  protected int b;
  
  public svi(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    paramArrayOfString = (tcv)tdc.a(10);
    this.a = ((Integer)paramArrayOfString.b("StoryFriendCacheCountMax", Integer.valueOf(300))).intValue();
    this.jdField_b_of_type_Int = ((Integer)paramArrayOfString.b("StoryFriendCacheCountNormal", Integer.valueOf(200))).intValue();
  }
  
  protected void a(String[] paramArrayOfString, svf paramsvf)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    String str;
    int j;
    if (i < m)
    {
      str = paramArrayOfString[i];
      if (paramsvf.a)
      {
        j = 50;
        label31:
        if (!a(str, j)) {
          break label60;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j = this.a;
      break label31;
      label60:
      File localFile = new File(str);
      double d = a(localFile);
      File[] arrayOfFile = localFile.listFiles();
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfFile.length;
      j = 0;
      while (j < k)
      {
        localArrayList.add(new svj(this, arrayOfFile[j]));
        j += 1;
      }
      Collections.sort(localArrayList);
      int n = localArrayList.size();
      k = 0;
      j = 0;
      while (j < n)
      {
        if (j % 150 == 0) {}
        try
        {
          Thread.sleep(100L);
          if ((j % 20 == 0) && (a(str, this.jdField_b_of_type_Int))) {
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
          a(((svj)localArrayList.get(j)).a);
          k += 1;
          j += 1;
        }
      }
      paramsvf.jdField_b_of_type_Double = (d - a(localFile) + paramsvf.jdField_b_of_type_Double);
      paramsvf.jdField_b_of_type_Int += k;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = new File(paramString).listFiles();
    if (paramString == null) {}
    while (paramString.length <= paramInt) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svi
 * JD-Core Version:    0.7.0.1
 */