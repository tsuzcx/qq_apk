import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import org.json.JSONArray;
import org.json.JSONObject;

public class pdh
{
  private final avom jdField_a_of_type_Avom = new pdi(this);
  public HotPicData a;
  private PublicAccountHotPicPanel jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  
  private pdh(pdd parampdd) {}
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
  }
  
  View a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel = ((PublicAccountHotPicPanel)View.inflate(paramContext, 2131559652, null));
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.a(this.jdField_a_of_type_Pdd.a(), (BaseActivity)paramContext, null, null);
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(this.jdField_a_of_type_Avom);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.f();
    return this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("picType", 3);
      localJSONObject.put("url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalUrl);
      localJSONObject.put("md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalMD5);
      localJSONObject.put("width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalWidth);
      localJSONObject.put("height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalHeight);
      localJSONObject.put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url);
      localJSONObject.put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.md5);
      localJSONObject.put("thumbnail_width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.width);
      localJSONObject.put("thumbnail_height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.height);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
      paramJSONObject.put("picInfoList", localJSONArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdh
 * JD-Core Version:    0.7.0.1
 */