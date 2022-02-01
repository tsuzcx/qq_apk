import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class noq
  extends ReportDialog
{
  private int jdField_a_of_type_Int;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private String jdField_a_of_type_JavaLangString;
  private List<ngc> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private nov jdField_a_of_type_Nov;
  private String b;
  
  public noq(Context paramContext, int paramInt, List<ngc> paramList, String paramString1, String paramString2)
  {
    super(paramContext, 2131755829);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    a();
    QLog.d("AVGameQuestionClassSelectDialog", 2, "AVGameQuestionClassSelectDialog init");
  }
  
  private void a()
  {
    setContentView(2131558750);
    getWindow().setLayout(-1, -1);
    Object localObject = (ImageView)findViewById(2131363311);
    TextView localTextView = (TextView)findViewById(2131363313);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString));
      localObject = (Button)findViewById(2131363240);
      if ((this.b == null) || (this.b.length() <= 0)) {
        break label262;
      }
      ((Button)localObject).setBackgroundDrawable(URLDrawable.getDrawable(this.b));
    }
    for (;;)
    {
      ((Button)localObject).setOnClickListener(new nor(this));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363239));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 2);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_Nov = new nov(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Nov);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new nou(this, 0, 0));
      findViewById(2131376947).setOnClickListener(new nos(this));
      findViewById(2131364405).setOnClickListener(new not(this));
      return;
      ((ImageView)localObject).setVisibility(8);
      localTextView.setVisibility(0);
      break;
      label262:
      ((Button)localObject).setText(getContext().getString(2131690418));
    }
  }
  
  public static void a(Context paramContext, int paramInt, List<ngc> paramList, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramInt == 0) || (paramList == null) || (paramList.size() == 0) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    new noq(paramContext, paramInt, paramList, paramString1, paramString2).show();
  }
  
  private void a(String paramString)
  {
    nfc.a().a(this.jdField_a_of_type_Int, paramString);
    dismiss();
    if (paramString == null) {
      paramString = getContext().getString(2131690418);
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B1F0", "0X800B1F0", this.jdField_a_of_type_Int, 0, "", "", paramString, "");
      return;
    }
  }
  
  private static void b(String paramString, ImageView paramImageView)
  {
    if ((paramString == null) || (paramImageView == null)) {}
    do
    {
      return;
      paramString = URLDrawable.getDrawable(paramString);
    } while (paramString == null);
    paramImageView.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     noq
 * JD-Core Version:    0.7.0.1
 */