import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class mok
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private mod jdField_a_of_type_Mod;
  private String b;
  
  public mok(Context paramContext, String paramString, mod parammod)
  {
    if ((TextUtils.isEmpty(paramString)) || (parammod == null))
    {
      if (mof.jdField_a_of_type_Mos.a()) {
        mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "new TransUrl error");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Mod = parammod;
    this.b = Uri.parse(paramString).getQueryParameter("_bid");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (mof.jdField_a_of_type_Mos.a()) {
      mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "transThread callback mode:" + paramInt);
    }
    if (this.jdField_a_of_type_Mod != null) {
      this.jdField_a_of_type_Mod.loaded(paramInt, paramString);
    }
  }
  
  private boolean a()
  {
    String str = mol.b(this.b);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return mof.a(this.jdField_a_of_type_AndroidContentContext, "html5/" + this.b + "/" + this.b + ".zip", str + this.b + ".zip");
  }
  
  public void a()
  {
    if (mof.jdField_a_of_type_Mos.a()) {
      mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl start:" + this.b);
    }
    mof.jdField_a_of_type_Int = 0;
    long l3 = System.currentTimeMillis();
    Object localObject1 = mol.a(this.b);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (mof.jdField_a_of_type_Mos.a()) {
        mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,html root dir is null!");
      }
      a(this.jdField_a_of_type_JavaLangString, 0);
      mof.a(this.b, 2, 0L, -1, "lixian_cover", "0");
      return;
    }
    String str1 = (String)localObject1 + this.b;
    Object localObject3 = mof.a(this.jdField_a_of_type_AndroidContentContext, this.b);
    Object localObject2 = mof.a(this.b);
    int j;
    long l1;
    if (localObject2 != null)
    {
      j = mof.a(this.jdField_a_of_type_AndroidContentContext, this.b);
      i = j;
      if (j != 1)
      {
        l1 = ((JSONObject)localObject2).optLong("expired", 0L);
        i = j;
        if (l1 > 0L)
        {
          i = j;
          if (l3 > l1) {
            i = 1;
          }
        }
      }
      if (i == 1)
      {
        mof.jdField_a_of_type_Int = 1;
        mpw.a(str1);
        mof.a(this.jdField_a_of_type_AndroidContentContext, this.b, 0);
        if (mof.jdField_a_of_type_Mos.a()) {
          mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,expire =1");
        }
      }
    }
    if (!mof.b(this.b))
    {
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = mof.a(this.b);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l1 = ((JSONObject)localObject2).optLong("expired", 0L);
        localObject1 = localObject2;
        if (l1 > 0L)
        {
          localObject1 = localObject2;
          if (l3 > l1)
          {
            if (mof.jdField_a_of_type_Int == 0) {
              mof.jdField_a_of_type_Int = 1;
            }
            mpw.a(str1);
            localObject1 = localObject2;
            if (mof.jdField_a_of_type_Mos.a())
            {
              mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,zip expire =1");
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    int i = 0;
    int k = 0;
    int n = 0;
    if (localObject3 != null)
    {
      j = ((JSONObject)localObject3).optInt("version", 0);
      l1 = ((JSONObject)localObject3).optLong("expired", 0L);
      i = j;
      if (l1 > 0L)
      {
        i = j;
        if (l3 > l1) {
          n = 1;
        }
      }
    }
    for (int m = j;; m = i)
    {
      if (localObject1 != null) {
        k = ((JSONObject)localObject1).optInt("version", 0);
      }
      if ((m == 0) && (k == 0))
      {
        if (mof.jdField_a_of_type_Mos.a()) {
          mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl:no package in both asset and data dir!");
        }
        if (mof.jdField_a_of_type_Int == 0) {
          mof.jdField_a_of_type_Int = 3;
        }
        mof.a(str1, this.b);
        a(this.jdField_a_of_type_JavaLangString, 0);
        localObject2 = this.b;
        i = mpq.a(this.jdField_a_of_type_AndroidContentContext);
        if (localObject1 == null) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          mof.a((String)localObject2, 5, 0L, i, "lixian_cover", (String)localObject1);
          return;
        }
      }
      if (mof.jdField_a_of_type_Mos.a()) {
        mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline:getVersion :" + String.valueOf(m) + "," + String.valueOf(k));
      }
      int i1 = 6;
      i = i1;
      localObject2 = localObject1;
      j = k;
      if (k < m)
      {
        i = i1;
        localObject2 = localObject1;
        j = k;
        if (n == 0)
        {
          if (!a()) {
            break label822;
          }
          if (!mof.b(this.b)) {
            break label810;
          }
          localObject1 = mof.a(this.b);
          if (localObject1 == null) {
            break label798;
          }
          j = ((JSONObject)localObject1).optInt("version", 0);
          localObject2 = localObject1;
          i = i1;
        }
      }
      if (j < m)
      {
        if (mof.jdField_a_of_type_Mos.a()) {
          mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline,doTransUrl:SD card update fail.");
        }
        if (mof.jdField_a_of_type_Int == 0) {
          mof.jdField_a_of_type_Int = 4;
        }
        mof.a(str1, this.b);
        a(this.jdField_a_of_type_JavaLangString, 0);
        localObject3 = this.b;
        l1 = j;
        j = mpq.a(this.jdField_a_of_type_AndroidContentContext);
        if (localObject2 == null) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          mof.a((String)localObject3, i, l1, j, "lixian_cover", (String)localObject1);
          return;
          label798:
          i = 10;
          localObject2 = localObject1;
          j = k;
          break;
          label810:
          i = 9;
          localObject2 = localObject1;
          j = k;
          break;
          label822:
          i = 8;
          localObject2 = localObject1;
          j = k;
          break;
        }
      }
      i = 1;
      if (localObject2 != null) {
        i = ((JSONObject)localObject2).optInt("loadmode", 1);
      }
      localObject3 = this.jdField_a_of_type_JavaLangString;
      String str2 = mof.d(this.jdField_a_of_type_JavaLangString);
      if (i == 2)
      {
        localObject1 = localObject3;
        if (!((String)localObject3).contains("_lv=")) {
          localObject1 = mof.a((String)localObject3, "_lv=" + j);
        }
      }
      label917:
      label1448:
      label1451:
      label1466:
      for (;;)
      {
        k = 0;
        if (localObject2 != null) {
          k = ((JSONObject)localObject2).optInt("verifyType", 0);
        }
        boolean bool;
        label998:
        long l2;
        if (new File(str1).exists())
        {
          if (mof.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
            mof.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          }
          l1 = System.currentTimeMillis();
          if ((i == 2) && (k == 1))
          {
            if (TextUtils.isEmpty(str2)) {
              break label1451;
            }
            bool = mpr.b(str2, str1, this.b);
            i = 3;
            l2 = System.currentTimeMillis() - l1;
            l1 = 0L;
            label1009:
            if (bool) {
              break label1448;
            }
            if (mof.jdField_a_of_type_Int == 0) {
              mof.jdField_a_of_type_Int = 5;
            }
            mof.a(str1, this.b);
            localObject1 = this.jdField_a_of_type_JavaLangString;
            if (mof.jdField_a_of_type_Mos.a()) {
              mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "-->offline:trans VerifyFile fail :" + this.b);
            }
            i = 0;
            j = 0;
          }
        }
        for (;;)
        {
          a((String)localObject1, i);
          if (j > 0)
          {
            long l4 = System.currentTimeMillis();
            mof.a(this.b, 0, j, -1, "lixian_cover", "" + (l4 - l3));
            if (mof.jdField_a_of_type_Mos.a()) {
              mof.jdField_a_of_type_Mos.a("HtmlCheckUpdate", 2, "trans time:" + (l4 - l3));
            }
            if (l2 > 0L)
            {
              mof.a(this.b, Long.valueOf(l2).intValue(), 1L, -1, "lixian_cover_sec", "");
              return;
              k = this.jdField_a_of_type_JavaLangString.indexOf(":");
              localObject1 = this.jdField_a_of_type_JavaLangString.substring(k + 3);
              localObject3 = "file://" + str1 + "/" + (String)localObject1;
              localObject1 = localObject3;
              if (!((String)localObject3).contains("_lv=")) {
                localObject1 = mof.a((String)localObject3, "_lv=" + j + "&_t=" + System.currentTimeMillis());
              }
              if (new File(str1 + "/" + str2).exists()) {
                break label1466;
              }
              localObject1 = this.jdField_a_of_type_JavaLangString;
              break label917;
              bool = mpr.a(str1, this.b);
              l4 = System.currentTimeMillis();
              l2 = 0L;
              l1 = l4 - l1;
              break label1009;
            }
            if (l1 <= 0L) {
              break;
            }
            mof.a(this.b, Long.valueOf(l1).intValue(), 2L, -1, "lixian_cover_sec", "");
            return;
          }
          mof.a(this.b, 7, j, mpq.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover", "0");
          return;
          continue;
          bool = false;
          break label998;
          l2 = 0L;
          l1 = 0L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mok
 * JD-Core Version:    0.7.0.1
 */