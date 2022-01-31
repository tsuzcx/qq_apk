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

public class nfo
{
  protected Context a;
  protected View.OnClickListener a;
  protected bfpt a;
  String a;
  protected ArrayList<nms> a;
  protected ney a;
  String b;
  
  public nfo(Context paramContext, ArrayList<nms> paramArrayList, ney paramney, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nfp(this);
    this.jdField_a_of_type_Bfpt = new nfq(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Ney = paramney;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<nms> a(nmr paramnmr, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnmr != null) && (paramnmr.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramnmr.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        nms localnms = (nms)localIterator.next();
        if ((localnms.jdField_b_of_type_Int == 0) || ((localnms.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramnmr.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localnms.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localnms.e)) || (TextUtils.isEmpty(localnms.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localnms);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localnms.e))
        {
          localArrayList.add(localnms);
          continue;
          if (localnms.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localnms.e)) && (!TextUtils.isEmpty(localnms.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnms.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localnms);
            }
          }
          else if ((!TextUtils.isEmpty(localnms.e)) && (!TextUtils.isEmpty(localnms.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localnms);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(nms paramnms)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (akdh)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((akdh)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = nol.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramnms.jdField_a_of_type_Int == 3) && (paramnms.jdField_c_of_type_Int == 23))
          {
            paramnms = paramnms.jdField_b_of_type_JavaLangString;
            localObject1 = new neu();
            ((neu)localObject1).a(paramnms);
            localObject1 = ((neu)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramnms = "02";
              nol.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramnms, String.valueOf(j), false);
            }
          }
          while (paramnms.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramnms = "01";
            }
          }
          paramnms = Uri.parse(paramnms.jdField_c_of_type_JavaLangString);
          try
          {
            paramnms = paramnms.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramnms))
            {
              paramnms = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                nol.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramnms, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramnms)
          {
            for (;;)
            {
              paramnms.printStackTrace();
              paramnms = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<nms> paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfo
 * JD-Core Version:    0.7.0.1
 */