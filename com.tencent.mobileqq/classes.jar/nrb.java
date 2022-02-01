import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nrb
{
  protected Context a;
  protected View.OnClickListener a;
  protected bkij a;
  String a;
  protected ArrayList<nyl> a;
  protected nql a;
  String b;
  
  public nrb(Context paramContext, ArrayList<nyl> paramArrayList, nql paramnql, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nrc(this);
    this.jdField_a_of_type_Bkij = new nrd(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Nql = paramnql;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<nyl> a(nyk paramnyk, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnyk != null) && (paramnyk.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramnyk.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        nyl localnyl = (nyl)localIterator.next();
        if ((localnyl.jdField_b_of_type_Int == 0) || ((localnyl.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramnyk.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localnyl.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localnyl.e)) || (TextUtils.isEmpty(localnyl.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localnyl);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localnyl.e))
        {
          localArrayList.add(localnyl);
          continue;
          if (localnyl.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localnyl.e)) && (!TextUtils.isEmpty(localnyl.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnyl.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localnyl);
            }
          }
          else if ((!TextUtils.isEmpty(localnyl.e)) && (!TextUtils.isEmpty(localnyl.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localnyl);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(nyl paramnyl)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (anrs)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((anrs)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = oat.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramnyl.jdField_a_of_type_Int == 3) && (paramnyl.jdField_c_of_type_Int == 23))
          {
            paramnyl = paramnyl.jdField_b_of_type_JavaLangString;
            localObject1 = new nqh();
            ((nqh)localObject1).a(paramnyl);
            localObject1 = ((nqh)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramnyl = "02";
              oat.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramnyl, String.valueOf(j), false);
            }
          }
          while (paramnyl.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramnyl = "01";
            }
          }
          paramnyl = Uri.parse(paramnyl.jdField_c_of_type_JavaLangString);
          try
          {
            paramnyl = paramnyl.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramnyl))
            {
              paramnyl = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                oat.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramnyl, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramnyl)
          {
            for (;;)
            {
              paramnyl.printStackTrace();
              paramnyl = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<nyl> paramArrayList)
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
 * Qualified Name:     nrb
 * JD-Core Version:    0.7.0.1
 */