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

public class nik
{
  protected Context a;
  protected View.OnClickListener a;
  protected bhuw a;
  String a;
  protected ArrayList<npo> a;
  protected nhu a;
  String b;
  
  public nik(Context paramContext, ArrayList<npo> paramArrayList, nhu paramnhu, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nil(this);
    this.jdField_a_of_type_Bhuw = new nim(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Nhu = paramnhu;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<npo> a(npn paramnpn, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnpn != null) && (paramnpn.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramnpn.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        npo localnpo = (npo)localIterator.next();
        if ((localnpo.jdField_b_of_type_Int == 0) || ((localnpo.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramnpn.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localnpo.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localnpo.e)) || (TextUtils.isEmpty(localnpo.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localnpo);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localnpo.e))
        {
          localArrayList.add(localnpo);
          continue;
          if (localnpo.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localnpo.e)) && (!TextUtils.isEmpty(localnpo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnpo.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localnpo);
            }
          }
          else if ((!TextUtils.isEmpty(localnpo.e)) && (!TextUtils.isEmpty(localnpo.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localnpo);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(npo paramnpo)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (alzl)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((alzl)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = nrt.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramnpo.jdField_a_of_type_Int == 3) && (paramnpo.jdField_c_of_type_Int == 23))
          {
            paramnpo = paramnpo.jdField_b_of_type_JavaLangString;
            localObject1 = new nhq();
            ((nhq)localObject1).a(paramnpo);
            localObject1 = ((nhq)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramnpo = "02";
              nrt.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramnpo, String.valueOf(j), false);
            }
          }
          while (paramnpo.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramnpo = "01";
            }
          }
          paramnpo = Uri.parse(paramnpo.jdField_c_of_type_JavaLangString);
          try
          {
            paramnpo = paramnpo.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramnpo))
            {
              paramnpo = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                nrt.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramnpo, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramnpo)
          {
            for (;;)
            {
              paramnpo.printStackTrace();
              paramnpo = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<npo> paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nik
 * JD-Core Version:    0.7.0.1
 */