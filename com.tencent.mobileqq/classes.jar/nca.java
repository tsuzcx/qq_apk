import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class nca
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private nbt jdField_a_of_type_Nbt;
  private String b;
  
  public nca(Context paramContext, String paramString, nbt paramnbt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramnbt == null))
    {
      if (nbv.jdField_a_of_type_Nci.a()) {
        nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "new TransUrl error");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Nbt = paramnbt;
    this.b = Uri.parse(paramString).getQueryParameter("_bid");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (nbv.jdField_a_of_type_Nci.a()) {
      nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "transThread callback mode:" + paramInt);
    }
    if (this.jdField_a_of_type_Nbt != null) {
      this.jdField_a_of_type_Nbt.loaded(paramInt, paramString);
    }
  }
  
  private boolean a()
  {
    String str = ncb.b(this.b);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return nbv.a(this.jdField_a_of_type_AndroidContentContext, "html5/" + this.b + "/" + this.b + ".zip", str + this.b + ".zip");
  }
  
  public void a()
  {
    if (nbv.jdField_a_of_type_Nci.a()) {
      nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl start:" + this.b);
    }
    nbv.jdField_a_of_type_Int = 0;
    long l3 = System.currentTimeMillis();
    Object localObject1 = ncb.a(this.b);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (nbv.jdField_a_of_type_Nci.a()) {
        nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,html root dir is null!");
      }
      a(this.jdField_a_of_type_JavaLangString, 0);
      nbv.a(this.b, 2, 0L, -1, "lixian_cover", "0");
      return;
    }
    String str1 = (String)localObject1 + this.b;
    Object localObject3 = nbv.a(this.jdField_a_of_type_AndroidContentContext, this.b);
    Object localObject2 = nbv.a(this.b);
    int j;
    long l1;
    if (localObject2 != null)
    {
      j = nbv.a(this.jdField_a_of_type_AndroidContentContext, this.b);
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
        nbv.jdField_a_of_type_Int = 1;
        ndq.a(str1);
        nbv.a(this.jdField_a_of_type_AndroidContentContext, this.b, 0);
        if (nbv.jdField_a_of_type_Nci.a()) {
          nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,expire =1");
        }
      }
    }
    if (!nbv.b(this.b))
    {
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = nbv.a(this.b);
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
            if (nbv.jdField_a_of_type_Int == 0) {
              nbv.jdField_a_of_type_Int = 1;
            }
            ndq.a(str1);
            localObject1 = localObject2;
            if (nbv.jdField_a_of_type_Nci.a())
            {
              nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,zip expire =1");
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
        if (nbv.jdField_a_of_type_Nci.a()) {
          nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl:no package in both asset and data dir!");
        }
        if (nbv.jdField_a_of_type_Int == 0) {
          nbv.jdField_a_of_type_Int = 3;
        }
        nbv.a(str1, this.b);
        a(this.jdField_a_of_type_JavaLangString, 0);
        localObject2 = this.b;
        i = ndk.a(this.jdField_a_of_type_AndroidContentContext);
        if (localObject1 == null) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          nbv.a((String)localObject2, 5, 0L, i, "lixian_cover", (String)localObject1);
          return;
        }
      }
      if (nbv.jdField_a_of_type_Nci.a()) {
        nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline:getVersion :" + String.valueOf(m) + "," + String.valueOf(k));
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
          if (!nbv.b(this.b)) {
            break label810;
          }
          localObject1 = nbv.a(this.b);
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
        if (nbv.jdField_a_of_type_Nci.a()) {
          nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline,doTransUrl:SD card update fail.");
        }
        if (nbv.jdField_a_of_type_Int == 0) {
          nbv.jdField_a_of_type_Int = 4;
        }
        nbv.a(str1, this.b);
        a(this.jdField_a_of_type_JavaLangString, 0);
        localObject3 = this.b;
        l1 = j;
        j = ndk.a(this.jdField_a_of_type_AndroidContentContext);
        if (localObject2 == null) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          nbv.a((String)localObject3, i, l1, j, "lixian_cover", (String)localObject1);
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
      String str2 = nbv.d(this.jdField_a_of_type_JavaLangString);
      if (i == 2)
      {
        localObject1 = localObject3;
        if (!((String)localObject3).contains("_lv=")) {
          localObject1 = nbv.a((String)localObject3, "_lv=" + j);
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
          if (nbv.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
            nbv.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          }
          l1 = System.currentTimeMillis();
          if ((i == 2) && (k == 1))
          {
            if (TextUtils.isEmpty(str2)) {
              break label1451;
            }
            bool = ndl.b(str2, str1, this.b);
            i = 3;
            l2 = System.currentTimeMillis() - l1;
            l1 = 0L;
            label1009:
            if (bool) {
              break label1448;
            }
            if (nbv.jdField_a_of_type_Int == 0) {
              nbv.jdField_a_of_type_Int = 5;
            }
            nbv.a(str1, this.b);
            localObject1 = this.jdField_a_of_type_JavaLangString;
            if (nbv.jdField_a_of_type_Nci.a()) {
              nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "-->offline:trans VerifyFile fail :" + this.b);
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
            nbv.a(this.b, 0, j, -1, "lixian_cover", "" + (l4 - l3));
            if (nbv.jdField_a_of_type_Nci.a()) {
              nbv.jdField_a_of_type_Nci.a("HtmlCheckUpdate", 2, "trans time:" + (l4 - l3));
            }
            if (l2 > 0L)
            {
              nbv.a(this.b, Long.valueOf(l2).intValue(), 1L, -1, "lixian_cover_sec", "");
              return;
              k = this.jdField_a_of_type_JavaLangString.indexOf(":");
              localObject1 = this.jdField_a_of_type_JavaLangString.substring(k + 3);
              localObject3 = "file://" + str1 + "/" + (String)localObject1;
              localObject1 = localObject3;
              if (!((String)localObject3).contains("_lv=")) {
                localObject1 = nbv.a((String)localObject3, "_lv=" + j + "&_t=" + System.currentTimeMillis());
              }
              if (new File(str1 + "/" + str2).exists()) {
                break label1466;
              }
              localObject1 = this.jdField_a_of_type_JavaLangString;
              break label917;
              bool = ndl.a(str1, this.b);
              l4 = System.currentTimeMillis();
              l2 = 0L;
              l1 = l4 - l1;
              break label1009;
            }
            if (l1 <= 0L) {
              break;
            }
            nbv.a(this.b, Long.valueOf(l1).intValue(), 2L, -1, "lixian_cover_sec", "");
            return;
          }
          nbv.a(this.b, 7, j, ndk.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover", "0");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nca
 * JD-Core Version:    0.7.0.1
 */