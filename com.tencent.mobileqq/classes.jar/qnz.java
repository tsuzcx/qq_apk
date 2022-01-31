import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qnz
{
  public int a;
  public long a;
  public LocalMediaInfo a;
  @Nullable
  public String a;
  public boolean a;
  private int[] a;
  public int b;
  public long b;
  @Nullable
  public String b;
  private boolean b;
  public long c;
  public String c;
  public long d;
  public String d;
  @NotNull
  public String e = "";
  public String f = "";
  private String g;
  
  public qnz()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    try
    {
      paramString = paramString.split("x");
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        if (paramString.length >= 2) {
          j = Integer.parseInt(paramString[i]);
        }
        return j;
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      QLog.e("LocalMediaInfo", 1, "getWidth error", paramString);
    }
  }
  
  private void a()
  {
    for (int i = 0;; i = 1) {
      for (;;)
      {
        try
        {
          if (this.jdField_b_of_type_Boolean) {
            return;
          }
          MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
          localMediaMetadataRetriever.setDataSource(this.jdField_b_of_type_JavaLangString);
          int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
          int k = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
          if (Build.VERSION.SDK_INT >= 17)
          {
            int m = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(24));
            if ((m == 90) || (m == 270)) {
              break;
            }
            if (i != 0)
            {
              this.g = (k + "x" + j);
              this.jdField_b_of_type_Boolean = true;
            }
          }
          else
          {
            QLog.e("LocalMediaInfo", 1, "checkAndSetExifResolution can't get rotation...");
            continue;
          }
          this.g = (j + "x" + k);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("LocalMediaInfo", 1, "checkAndSetExifResolution", localThrowable);
          return;
        }
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ArrayOfInt[0] == 0) || (this.jdField_a_of_type_ArrayOfInt[1] == 0))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString, localOptions);
      this.jdField_a_of_type_ArrayOfInt[0] = localOptions.outWidth;
      this.jdField_a_of_type_ArrayOfInt[1] = localOptions.outHeight;
    }
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      return this.jdField_a_of_type_ArrayOfInt[0];
    }
    a();
    if (TextUtils.isEmpty(this.g)) {
      return a(this.c, true);
    }
    return a(this.g, true);
  }
  
  public int b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      return this.jdField_a_of_type_ArrayOfInt[1];
    }
    a();
    if (TextUtils.isEmpty(this.g)) {
      return a(this.c, false);
    }
    return a(this.g, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qnz
 * JD-Core Version:    0.7.0.1
 */