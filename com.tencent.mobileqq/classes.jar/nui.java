import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nui
{
  protected Context a;
  protected View.OnClickListener a;
  protected AdapterView.OnItemClickListener a;
  String a;
  protected ArrayList<obr> a;
  protected nts a;
  String b;
  
  public nui(Context paramContext, ArrayList<obr> paramArrayList, nts paramnts, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nuj(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new nuk(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Nts = paramnts;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<obr> a(obq paramobq, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramobq != null) && (paramobq.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramobq.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        obr localobr = (obr)localIterator.next();
        if ((localobr.jdField_b_of_type_Int == 0) || ((localobr.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramobq.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localobr.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localobr.e)) || (TextUtils.isEmpty(localobr.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localobr);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localobr.e))
        {
          localArrayList.add(localobr);
          continue;
          if (localobr.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localobr.e)) && (!TextUtils.isEmpty(localobr.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localobr.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localobr);
            }
          }
          else if ((!TextUtils.isEmpty(localobr.e)) && (!TextUtils.isEmpty(localobr.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localobr);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(obr paramobr)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (amxz)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((amxz)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = odq.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramobr.jdField_a_of_type_Int == 3) && (paramobr.jdField_c_of_type_Int == 23))
          {
            paramobr = paramobr.jdField_b_of_type_JavaLangString;
            localObject1 = new nto();
            ((nto)localObject1).a(paramobr);
            localObject1 = ((nto)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramobr = "02";
              odq.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramobr, String.valueOf(j), false);
            }
          }
          while (paramobr.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramobr = "01";
            }
          }
          paramobr = Uri.parse(paramobr.jdField_c_of_type_JavaLangString);
          try
          {
            paramobr = paramobr.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramobr))
            {
              paramobr = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                odq.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramobr, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramobr)
          {
            for (;;)
            {
              paramobr.printStackTrace();
              paramobr = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<obr> paramArrayList)
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
 * Qualified Name:     nui
 * JD-Core Version:    0.7.0.1
 */