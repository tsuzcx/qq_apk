import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tey
  extends tfd
{
  private bahv a;
  
  public tey(Activity paramActivity)
  {
    super(paramActivity);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } });
    }
  }
  
  private List<bahx>[] a(Context paramContext, List<int[]> paramList)
  {
    List[] arrayOfList = (List[])new ArrayList[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(i);
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfInt.length;
      int j = 0;
      if (j < k)
      {
        int m = arrayOfInt[j];
        bahx localbahx = new bahx();
        localbahx.c = a(m);
        localbahx.jdField_b_of_type_Boolean = true;
        switch (m)
        {
        }
        for (;;)
        {
          localArrayList.add(localbahx);
          j += 1;
          break;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131653446);
          localbahx.jdField_b_of_type_Int = 2130845824;
          urp.a("share", "exp_video", 0, 0, new String[0]);
          continue;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131653445);
          localbahx.jdField_b_of_type_Int = 2130845715;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630983);
          localbahx.jdField_b_of_type_Int = 2130845715;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630996);
          localbahx.jdField_b_of_type_Int = 2130845340;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131631003);
          localbahx.jdField_b_of_type_Int = 2130845718;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630986);
          localbahx.jdField_b_of_type_Int = 2130838730;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131631000);
          localbahx.jdField_b_of_type_Int = 2130845717;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131625730);
          localbahx.jdField_b_of_type_Int = 2130838728;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = ajjy.a(2131633966);
          localbahx.jdField_b_of_type_Int = 2130845580;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = ajjy.a(2131633968);
          localbahx.jdField_b_of_type_Int = 2130845578;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = ajjy.a(2131633969);
          localbahx.jdField_b_of_type_Int = 2130845579;
          continue;
          localbahx.jdField_a_of_type_JavaLangString = ajjy.a(2131633967);
          localbahx.jdField_b_of_type_Int = 2130845586;
        }
      }
      arrayOfList[i] = localArrayList;
      i += 1;
    }
    return arrayOfList;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 9;
    case 4: 
      return 10;
    case 5: 
      return 12;
    case 6: 
      return 1;
    case 7: 
      return 39;
    case 8: 
      return 40;
    case 9: 
      return 11;
    case 10: 
      return 41;
    case 11: 
      return 22;
    }
    return 42;
  }
  
  public void a()
  {
    tez localtez;
    tfa localtfa;
    Activity localActivity;
    String str;
    if (this.jdField_a_of_type_Bahv == null)
    {
      localtez = new tez(this);
      localtfa = new tfa(this);
      localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_Bahv = new bahv(localActivity, true);
      if (!this.jdField_a_of_type_Boolean) {
        break label162;
      }
      bahv localbahv = this.jdField_a_of_type_Bahv;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
      str = localActivity.getString(2131653614);
      label82:
      localbahv.a(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bahv.a(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_Bahv.a(localtez);
      this.jdField_a_of_type_Bahv.a(localtfa);
      this.jdField_a_of_type_Bahv.a(new tfb(this));
      if (this.jdField_a_of_type_Bahv.a()) {
        break;
      }
      this.jdField_a_of_type_Bahv.a();
      return;
      label154:
      str = this.jdField_a_of_type_JavaLangString;
      break label82;
      label162:
      this.jdField_a_of_type_Bahv.e();
    }
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 9: 
      return 3;
    case 10: 
      return 4;
    case 12: 
      return 5;
    case 1: 
      return 6;
    case 39: 
      return 7;
    case 40: 
      return 8;
    case 11: 
      return 9;
    case 41: 
      return 10;
    case 22: 
      return 11;
    }
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tey
 * JD-Core Version:    0.7.0.1
 */