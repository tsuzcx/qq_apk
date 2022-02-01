import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;
import org.json.JSONObject;

public class nzd
  extends nyy
{
  private uyg a;
  public int d;
  public String d;
  public int e;
  
  public static nzd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        nzd localnzd = new nzd();
        localnzd.jdField_d_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
        localnzd.jdField_d_of_type_Int = paramJSONObject.optInt("imageWidth");
        localnzd.e = paramJSONObject.optInt("imageHeight");
        boolean bool = TextUtils.isEmpty(localnzd.jdField_d_of_type_JavaLangString);
        if (!bool) {
          return localnzd;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, nyq paramnyq, boolean paramBoolean)
  {
    super.a(paramContext, paramString1, paramString2, paramString3, paramInt, paramnyq, paramBoolean);
    paramString1 = LayoutInflater.from(paramContext).inflate(2131560226, null);
    paramString2 = (ResizeURLImageView)paramString1.findViewById(2131372649);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    try
    {
      paramString3 = new URL(this.jdField_d_of_type_JavaLangString);
      paramString2.setImage(paramString3);
      if (sun.a().a(paramString3)) {
        this.jdField_a_of_type_Int = 2;
      }
      for (;;)
      {
        a(paramContext, paramString1);
        return paramString1;
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Uyg = new nze(this, paramString1, paramString2);
        paramString2.setPublicAccountImageDownListener(this.jdField_a_of_type_Uyg);
        paramString1.findViewById(2131370303).setVisibility(0);
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Int == 3) {
      d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      nzi localnzi = (nzi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248);
      if (localnzi != null) {
        localnzi.a(this.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Uyg = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370303).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366280).setVisibility(8);
    try
    {
      URL localURL = new URL(this.jdField_d_of_type_JavaLangString);
      ((ResizeURLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372649)).setImage(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzd
 * JD-Core Version:    0.7.0.1
 */