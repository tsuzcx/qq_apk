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

public class nsz
{
  protected Context a;
  protected View.OnClickListener a;
  protected bljm a;
  String a;
  protected ArrayList<oag> a;
  protected nsj a;
  String b;
  
  public nsz(Context paramContext, ArrayList<oag> paramArrayList, nsj paramnsj, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nta(this);
    this.jdField_a_of_type_Bljm = new ntb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Nsj = paramnsj;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<oag> a(oaf paramoaf, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramoaf != null) && (paramoaf.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramoaf.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        oag localoag = (oag)localIterator.next();
        if ((localoag.jdField_b_of_type_Int == 0) || ((localoag.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramoaf.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localoag.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localoag.e)) || (TextUtils.isEmpty(localoag.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localoag);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localoag.e))
        {
          localArrayList.add(localoag);
          continue;
          if (localoag.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localoag.e)) && (!TextUtils.isEmpty(localoag.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localoag.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localoag);
            }
          }
          else if ((!TextUtils.isEmpty(localoag.e)) && (!TextUtils.isEmpty(localoag.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localoag);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(oag paramoag)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (aody)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((aody)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = ocd.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramoag.jdField_a_of_type_Int == 3) && (paramoag.jdField_c_of_type_Int == 23))
          {
            paramoag = paramoag.jdField_b_of_type_JavaLangString;
            localObject1 = new nsf();
            ((nsf)localObject1).a(paramoag);
            localObject1 = ((nsf)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramoag = "02";
              ocd.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramoag, String.valueOf(j), false);
            }
          }
          while (paramoag.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramoag = "01";
            }
          }
          paramoag = Uri.parse(paramoag.jdField_c_of_type_JavaLangString);
          try
          {
            paramoag = paramoag.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramoag))
            {
              paramoag = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                ocd.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramoag, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramoag)
          {
            for (;;)
            {
              paramoag.printStackTrace();
              paramoag = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<oag> paramArrayList)
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
 * Qualified Name:     nsz
 * JD-Core Version:    0.7.0.1
 */