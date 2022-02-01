import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;
import org.json.JSONObject;

public class nxj
  extends nxe
{
  private uwv a;
  public int d;
  public String d;
  public int e;
  
  public static nxj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        nxj localnxj = new nxj();
        localnxj.jdField_d_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
        localnxj.jdField_d_of_type_Int = paramJSONObject.optInt("imageWidth");
        localnxj.e = paramJSONObject.optInt("imageHeight");
        boolean bool = TextUtils.isEmpty(localnxj.jdField_d_of_type_JavaLangString);
        if (!bool) {
          return localnxj;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, nww paramnww, boolean paramBoolean)
  {
    super.a(paramContext, paramString1, paramString2, paramString3, paramInt, paramnww, paramBoolean);
    paramString1 = LayoutInflater.from(paramContext).inflate(2131560214, null);
    paramString2 = (ResizeURLImageView)paramString1.findViewById(2131372538);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    try
    {
      paramString3 = new URL(this.jdField_d_of_type_JavaLangString);
      paramString2.setImage(paramString3);
      if (tdv.a().a(paramString3)) {
        this.jdField_a_of_type_Int = 2;
      }
      for (;;)
      {
        a(paramContext, paramString1);
        return paramString1;
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Uwv = new nxk(this, paramString1, paramString2);
        paramString2.setPublicAccountImageDownListener(this.jdField_a_of_type_Uwv);
        paramString1.findViewById(2131370202).setVisibility(0);
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
      nxo localnxo = (nxo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248);
      if (localnxo != null) {
        localnxo.a(this.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Uwv = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370202).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366231).setVisibility(8);
    try
    {
      URL localURL = new URL(this.jdField_d_of_type_JavaLangString);
      ((ResizeURLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372538)).setImage(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxj
 * JD-Core Version:    0.7.0.1
 */