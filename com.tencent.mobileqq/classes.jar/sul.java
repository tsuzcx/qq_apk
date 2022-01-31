import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class sul
{
  public int a;
  public long a;
  public ayrv a;
  public MessageForShortVideo a;
  public String a;
  public Map<String, Object> a;
  public sue a;
  public suk a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g = 1;
  
  public sul()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static sul a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, false);
  }
  
  public static sul a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, null, paramInt, paramBoolean);
  }
  
  private static sul a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    sul localsul = new sul();
    StoryVideoItem localStoryVideoItem = ((tcz)tdc.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine()))
    {
      localsul.e = sum.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, false, false);
      localsul.f = sum.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, true, false);
      localsul.jdField_b_of_type_Int = 0;
      localsul.jdField_b_of_type_JavaLangString = paramString1;
      localsul.jdField_a_of_type_Int = paramInt;
      localsul.jdField_a_of_type_JavaLangString = a(paramString1, paramInt);
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      localsul.jdField_c_of_type_JavaLangString = paramString1;
      if (paramBoolean) {
        paramString2 = "";
      }
      localsul.jdField_d_of_type_JavaLangString = paramString2;
      localsul.jdField_c_of_type_Boolean = paramBoolean;
      return localsul;
      localsul.e = sum.a(paramString1, paramInt, false, false);
      localsul.f = sum.a(paramString1, paramInt, true, false);
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof sul))
    {
      paramObject = (sul)paramObject;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fileType=" + ssi.a(this.jdField_a_of_type_Int) + ", status=" + this.jdField_b_of_type_Int + ", downloadUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", localPath='" + this.e + '\'' + ", localTmpPath='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sul
 * JD-Core Version:    0.7.0.1
 */