package com.tencent.mobileqq.richstatus;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StatusXmlHandler
  extends DefaultHandler
{
  private SparseArray<ActionInfo> jdField_a_of_type_AndroidUtilSparseArray;
  private ActionInfo jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo;
  private StateTag jdField_a_of_type_ComTencentMobileqqRichstatusStateTag;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList<StateTag> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Stack<ActionInfo> jdField_a_of_type_JavaUtilStack;
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList<Integer> b;
  private ArrayList<ActionInfo> c;
  
  public StatusXmlHandler()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("StateList", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put("SubStateList", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("RichState", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put("ActionId", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("Display", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("ActionName", Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilHashMap.put("Describe", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilHashMap.put("IconURL", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("TinyIcon", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("Type", Integer.valueOf(10));
    this.jdField_a_of_type_JavaUtilHashMap.put("Parameter", Integer.valueOf(11));
    this.jdField_a_of_type_JavaUtilHashMap.put("DataURL", Integer.valueOf(12));
    this.jdField_a_of_type_JavaUtilHashMap.put("CoverURL", Integer.valueOf(13));
    this.jdField_a_of_type_JavaUtilHashMap.put("NativeList", Integer.valueOf(14));
    this.jdField_a_of_type_JavaUtilHashMap.put("ListParam", Integer.valueOf(15));
    this.jdField_a_of_type_JavaUtilHashMap.put("NativeDetail", Integer.valueOf(16));
    this.jdField_a_of_type_JavaUtilHashMap.put("DetailParam", Integer.valueOf(17));
    this.jdField_a_of_type_JavaUtilHashMap.put("Tags", Integer.valueOf(18));
    this.jdField_a_of_type_JavaUtilHashMap.put("StateTag", Integer.valueOf(19));
    this.jdField_a_of_type_JavaUtilHashMap.put("TagName", Integer.valueOf(20));
    this.jdField_a_of_type_JavaUtilHashMap.put("IdList", Integer.valueOf(21));
    this.jdField_a_of_type_JavaUtilHashMap.put("Action_id", Integer.valueOf(22));
  }
  
  public SparseArray<ActionInfo> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public ArrayList<StateTag> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (StateTag)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((StateTag)localObject).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = ((StateTag)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          int j = ((Integer)((Iterator)localObject).next()).intValue();
          ActionInfo localActionInfo = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
          if ((localActionInfo != null) && (localActionInfo.jdField_b_of_type_Int == 2))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("filter xml name = ");
              localStringBuilder.append(localActionInfo.c);
              QLog.d("RichStatus", 2, localStringBuilder.toString());
            }
            ((Iterator)localObject).remove();
          }
        }
      }
      i += 1;
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = false;
    paramString1 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    paramString2 = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    if (paramString2 == null) {
      return;
    }
    int i = paramString2.intValue();
    if (i != 20)
    {
      if (i != 22) {
        switch (i)
        {
        default: 
          return;
        case 17: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.k = paramString1;
          return;
        case 16: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.j = paramString1;
          return;
        case 15: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.i = paramString1;
          return;
        case 14: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.h = paramString1;
          return;
        case 13: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.g = paramString1;
          return;
        case 12: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.f = paramString1;
          return;
        case 11: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.e = paramString1;
          return;
        case 10: 
          if ("0".equals(paramString1))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_b_of_type_Int = 4;
            return;
          }
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_b_of_type_Int = 3;
            return;
          }
          if ("2".equals(paramString1))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_b_of_type_Int = 2;
            return;
          }
          if (!"4".equals(paramString1)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_b_of_type_Int = 5;
          return;
        case 9: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_b_of_type_JavaLangString = paramString1;
          return;
        case 8: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_JavaLangString = paramString1;
          return;
        case 7: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.c = paramString1;
          return;
        case 6: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.d = paramString1;
          return;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramString1);
          return;
        case 4: 
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_Int = Integer.parseInt(paramString1);
            return;
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          paramString2 = new StringBuilder();
          paramString2.append(paramString1.toString());
          paramString2.append(", ");
          paramString2.append(paramString1.getStackTrace().toString());
          QLog.d("Q.richstatus.xml", 2, paramString2.toString());
          return;
        case 3: 
          if (this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_Int == 0) {
            break;
          }
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo);
          if (this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_Boolean) {
            this.c.add(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo);
          }
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = null;
          return;
        case 1: 
        case 2: 
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = ((ActionInfo)this.jdField_a_of_type_JavaUtilStack.pop());
          if (this.c.size() == 0) {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_JavaUtilArrayList = null;
          }
          if (this.jdField_a_of_type_JavaUtilStack.size() <= 0) {
            break;
          }
          this.c = ((ActionInfo)this.jdField_a_of_type_JavaUtilStack.lastElement()).jdField_a_of_type_JavaUtilArrayList;
          return;
        }
      } else {
        this.b.add(Integer.valueOf(Integer.parseInt(paramString1)));
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag.jdField_a_of_type_JavaLangString = paramString1;
    }
  }
  
  public void startDocument()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag = new StateTag();
    this.jdField_a_of_type_JavaUtilStack = new Stack();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = new ActionInfo(-1);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(-1, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo);
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_Boolean = true;
    paramString1 = this.jdField_a_of_type_JavaLangStringBuilder;
    paramString1.replace(0, paramString1.length(), "");
    if ((!"StateList".equals(paramString2)) && (!"SubStateList".equals(paramString2)))
    {
      if ("RichState".equals(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = new ActionInfo(-1);
        return;
      }
      if ("StateTag".equals(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag = new StateTag();
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag);
        return;
      }
      if ("IdList".equals(paramString2))
      {
        this.b = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag.jdField_a_of_type_JavaUtilArrayList = this.b;
      }
    }
    else
    {
      this.c = new ArrayList();
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo;
      paramString1.jdField_a_of_type_JavaUtilArrayList = this.c;
      this.jdField_a_of_type_JavaUtilStack.push(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusXmlHandler
 * JD-Core Version:    0.7.0.1
 */