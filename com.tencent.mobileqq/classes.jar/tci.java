import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class tci
{
  private aqre jdField_a_of_type_Aqre;
  private ColorNote jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public tci(String paramString)
  {
    this.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = new aqrv().a(16908290).a("viola:" + paramString).b("defaultTitle").c("defaultSubTitle").d("https://default").a();
  }
  
  public static JSONObject a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return new JSONObject();
    }
    try
    {
      paramColorNote = new JSONObject(new String(paramColorNote.getReserve()));
      return paramColorNote;
    }
    catch (Exception paramColorNote)
    {
      QLog.d("ViolaColorNote", 1, "[getViolaColorNoteData]: " + paramColorNote.getMessage());
    }
    return new JSONObject();
  }
  
  public static JSONObject b(ColorNote paramColorNote)
  {
    return a(paramColorNote).optJSONObject("report");
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_OrgJsonJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote == null)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mMainTitle = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mSubTitle = this.jdField_a_of_type_OrgJsonJSONObject.optString("subTitle");
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mPicUrl = this.jdField_a_of_type_OrgJsonJSONObject.optString("imageUrl");
      this.jdField_a_of_type_OrgJsonJSONObject.put("param", this.jdField_a_of_type_JavaLangString).put("url", this.b).put("useTransParentFragment", this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mReserve = this.jdField_a_of_type_OrgJsonJSONObject.toString().getBytes();
      this.jdField_a_of_type_Aqre.a(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ViolaColorNote", 1, "[setColorBallData]: " + localException.getMessage());
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put(str, paramJSONObject.opt(str));
        }
        catch (JSONException localJSONException)
        {
          QLog.e("ViolaColorNote", 1, localJSONException.getMessage());
        }
      }
    }
  }
  
  public ColorNote a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  }
  
  public tci a(aqre paramaqre)
  {
    this.jdField_a_of_type_Aqre = paramaqre;
    return this;
  }
  
  public tci a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public tci a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqre == null) {}
    while (!this.jdField_a_of_type_Aqre.c()) {
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqre == null) || (1 != paramInt)) {
      return;
    }
    b();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      c(paramJSONObject);
    } while (this.jdField_a_of_type_Aqre == null);
    this.jdField_a_of_type_Aqre.k();
  }
  
  public void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tci
 * JD-Core Version:    0.7.0.1
 */