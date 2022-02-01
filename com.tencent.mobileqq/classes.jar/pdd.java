import android.app.Activity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class pdd
  implements QQLifecycleBridge, QQViewBridge
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private QQViewCallback jdField_a_of_type_ComTencentTkdCommentPublisherQqUtilQQViewCallback;
  private final pdf jdField_a_of_type_Pdf;
  private final pdh jdField_a_of_type_Pdh;
  private final pdj jdField_a_of_type_Pdj;
  private pdk jdField_a_of_type_Pdk;
  private final pdl jdField_a_of_type_Pdl;
  
  public pdd(pdl parampdl)
  {
    this.jdField_a_of_type_Pdl = parampdl;
    this.jdField_a_of_type_Pdj = new pdj(this, null);
    this.jdField_a_of_type_Pdf = new pdf(this, null);
    this.jdField_a_of_type_Pdh = new pdh(this, null);
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Pdh.a(paramString);
      paramString = paramString.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(pdk parampdk)
  {
    this.jdField_a_of_type_Pdk = parampdk;
  }
  
  public void bindCallback(QQViewCallback paramQQViewCallback)
  {
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqUtilQQViewCallback = paramQQViewCallback;
  }
  
  public void bindInput(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void deleteGif()
  {
    pdh.a(this.jdField_a_of_type_Pdh);
  }
  
  public Editable.Factory getEditFactory()
  {
    return new pde(this);
  }
  
  public View getEmotionPanel(Activity paramActivity)
  {
    return this.jdField_a_of_type_Pdf.a(paramActivity);
  }
  
  public String getEmotionText(String paramString)
  {
    return bcsc.b(paramString);
  }
  
  public View getGifPanel(Activity paramActivity)
  {
    return this.jdField_a_of_type_Pdh.a(paramActivity);
  }
  
  public int getTextLength(Editable paramEditable)
  {
    if ((paramEditable instanceof owe)) {
      return ((owe)paramEditable).a();
    }
    return paramEditable.length();
  }
  
  public boolean hasGif()
  {
    return this.jdField_a_of_type_Pdh.a != null;
  }
  
  public boolean isNightMode()
  {
    return ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onDeleteLink()
  {
    this.jdField_a_of_type_Pdj.b();
  }
  
  public void onDeliever(String paramString)
  {
    if (this.jdField_a_of_type_Pdk != null) {
      this.jdField_a_of_type_Pdk.a(a(paramString));
    }
  }
  
  public void onDelieverBiu(String paramString)
  {
    if (this.jdField_a_of_type_Pdk != null) {
      this.jdField_a_of_type_Pdk.b(a(paramString));
    }
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pdj.a();
    this.jdField_a_of_type_Pdf.a();
    this.jdField_a_of_type_Pdh.a();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void openLink(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Pdj.a(paramViewGroup);
    pdj.a(this.jdField_a_of_type_Pdj, paramViewGroup.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdd
 * JD-Core Version:    0.7.0.1
 */