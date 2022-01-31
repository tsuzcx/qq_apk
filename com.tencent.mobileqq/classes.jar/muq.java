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

public class muq
{
  protected Context a;
  protected View.OnClickListener a;
  protected behi a;
  String a;
  protected ArrayList<nbu> a;
  protected mua a;
  String b;
  
  public muq(Context paramContext, ArrayList<nbu> paramArrayList, mua parammua, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new mur(this);
    this.jdField_a_of_type_Behi = new mus(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Mua = parammua;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<nbu> a(nbt paramnbt, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnbt != null) && (paramnbt.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramnbt.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        nbu localnbu = (nbu)localIterator.next();
        if ((localnbu.jdField_b_of_type_Int == 0) || ((localnbu.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramnbt.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localnbu.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localnbu.e)) || (TextUtils.isEmpty(localnbu.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localnbu);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localnbu.e))
        {
          localArrayList.add(localnbu);
          continue;
          if (localnbu.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localnbu.e)) && (!TextUtils.isEmpty(localnbu.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnbu.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localnbu);
            }
          }
          else if ((!TextUtils.isEmpty(localnbu.e)) && (!TextUtils.isEmpty(localnbu.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localnbu);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(nbu paramnbu)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (ajoy)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((ajoy)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = ndn.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramnbu.jdField_a_of_type_Int == 3) && (paramnbu.jdField_c_of_type_Int == 23))
          {
            paramnbu = paramnbu.jdField_b_of_type_JavaLangString;
            localObject1 = new mtw();
            ((mtw)localObject1).a(paramnbu);
            localObject1 = ((mtw)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramnbu = "02";
              ndn.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramnbu, String.valueOf(j), false);
            }
          }
          while (paramnbu.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramnbu = "01";
            }
          }
          paramnbu = Uri.parse(paramnbu.jdField_c_of_type_JavaLangString);
          try
          {
            paramnbu = paramnbu.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramnbu))
            {
              paramnbu = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                ndn.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramnbu, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramnbu)
          {
            for (;;)
            {
              paramnbu.printStackTrace();
              paramnbu = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<nbu> paramArrayList)
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
 * Qualified Name:     muq
 * JD-Core Version:    0.7.0.1
 */