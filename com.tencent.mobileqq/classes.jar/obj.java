import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class obj
{
  protected Context a;
  protected View.OnClickListener a;
  protected AdapterView.OnItemClickListener a;
  String a;
  protected ArrayList<oji> a;
  protected oat a;
  String b;
  
  public obj(Context paramContext, ArrayList<oji> paramArrayList, oat paramoat, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new obk(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new obl(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Oat = paramoat;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<oji> a(ojh paramojh, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramojh != null) && (paramojh.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramojh.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        oji localoji = (oji)localIterator.next();
        if ((localoji.jdField_b_of_type_Int == 0) || ((localoji.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramojh.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localoji.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localoji.e)) || (TextUtils.isEmpty(localoji.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localoji);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localoji.e))
        {
          localArrayList.add(localoji);
          continue;
          if (localoji.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localoji.e)) && (!TextUtils.isEmpty(localoji.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localoji.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localoji);
            }
          }
          else if ((!TextUtils.isEmpty(localoji.e)) && (!TextUtils.isEmpty(localoji.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localoji);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(oji paramoji)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (aoan)((QQAppInterface)localObject1).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        if (localObject2 != null)
        {
          localObject2 = ((aoan)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = olh.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramoji.jdField_a_of_type_Int == 3) && (paramoji.jdField_c_of_type_Int == 23))
          {
            paramoji = paramoji.jdField_b_of_type_JavaLangString;
            localObject1 = new oap();
            ((oap)localObject1).a(paramoji);
            localObject1 = ((oap)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramoji = "02";
              olh.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramoji, String.valueOf(j), false);
            }
          }
          while (paramoji.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramoji = "01";
            }
          }
          paramoji = Uri.parse(paramoji.jdField_c_of_type_JavaLangString);
          try
          {
            paramoji = paramoji.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramoji))
            {
              paramoji = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                olh.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramoji, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramoji)
          {
            for (;;)
            {
              paramoji.printStackTrace();
              paramoji = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<oji> paramArrayList)
  {
    if (paramArrayList.size() != this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label49;
      }
      if (paramArrayList.get(i) != this.jdField_a_of_type_JavaUtilArrayList.get(i)) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obj
 * JD-Core Version:    0.7.0.1
 */