import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;
import org.json.JSONObject;

public class nlq
  extends nll
{
  private spd a;
  public int d;
  public String d;
  public int e;
  
  public static nlq a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        nlq localnlq = new nlq();
        localnlq.jdField_d_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
        localnlq.jdField_d_of_type_Int = paramJSONObject.optInt("imageWidth");
        localnlq.e = paramJSONObject.optInt("imageHeight");
        boolean bool = TextUtils.isEmpty(localnlq.jdField_d_of_type_JavaLangString);
        if (!bool) {
          return localnlq;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, nld paramnld, boolean paramBoolean)
  {
    super.a(paramContext, paramString1, paramString2, paramString3, paramInt, paramnld, paramBoolean);
    paramString1 = LayoutInflater.from(paramContext).inflate(2131559973, null);
    paramString2 = (ResizeURLImageView)paramString1.findViewById(2131371631);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    try
    {
      paramString3 = new URL(this.jdField_d_of_type_JavaLangString);
      paramString2.a(paramString3);
      if (rpj.a().a(paramString3)) {
        this.jdField_a_of_type_Int = 2;
      }
      for (;;)
      {
        a(paramContext, paramString1);
        return paramString1;
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Spd = new nlr(this, paramString1, paramString2);
        paramString2.setPublicAccountImageDownListener(this.jdField_a_of_type_Spd);
        paramString1.findViewById(2131369490).setVisibility(0);
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
      nlv localnlv = (nlv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248);
      if (localnlv != null) {
        localnlv.a(this.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Spd = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369490).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131365892).setVisibility(8);
    try
    {
      URL localURL = new URL(this.jdField_d_of_type_JavaLangString);
      ((ResizeURLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371631)).a(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlq
 * JD-Core Version:    0.7.0.1
 */