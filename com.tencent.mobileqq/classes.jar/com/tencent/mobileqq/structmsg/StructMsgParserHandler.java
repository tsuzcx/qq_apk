package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StructMsgParserHandler
  extends DefaultHandler
  implements StructMsgConstants
{
  StructMsgNode jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode;
  private String jdField_a_of_type_JavaLangString;
  Stack jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AbsStructMsg a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode == null) {}
    for (;;)
    {
      return null;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode.a() > 0) {}
      for (StructMsgNode localStructMsgNode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode.a(0); localStructMsgNode != null; localStructMsgNode = null)
      {
        int i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode.a("serviceID"));
        if (i == 2) {
          return new StructMsgForAudioShare(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode);
        }
        if ((i == 3) || (i == 82) || (i == 120)) {
          return new StructMsgForHypertext(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode, i);
        }
        if (i == 5) {
          return new StructMsgForImageShare(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode);
        }
        return new StructMsgForGeneralShare(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    super.characters(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    StructMsgNode localStructMsgNode;
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      localStructMsgNode = (StructMsgNode)this.jdField_a_of_type_JavaUtilStack.peek();
      if (localStructMsgNode != null) {
        if (localStructMsgNode.jdField_a_of_type_JavaLangString != null) {
          break label81;
        }
      }
    }
    for (;;)
    {
      localStructMsgNode.jdField_a_of_type_JavaLangString = paramArrayOfChar;
      localStructMsgNode.jdField_a_of_type_JavaLangString = EmotcationConstants.b(localStructMsgNode.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b);
      return;
      label81:
      paramArrayOfChar = localStructMsgNode.jdField_a_of_type_JavaLangString.concat(paramArrayOfChar);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    this.jdField_a_of_type_JavaUtilStack.clear();
    this.jdField_a_of_type_JavaUtilStack = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    super.endElement(paramString1, paramString2, paramString3);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString1 = (StructMsgNode)this.jdField_a_of_type_JavaUtilStack.pop();
      if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode = paramString1;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((paramString1 != null) && (!"".equals(paramString1.jdField_a_of_type_JavaLangString))) {
          paramString1.jdField_a_of_type_Int = 3;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    super.startElement(paramString1, paramString2, paramString3, paramAttributes);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      localHashMap.put(paramAttributes.getLocalName(i), EmotcationConstants.b(paramAttributes.getValue(i), this.jdField_a_of_type_JavaLangString, this.b));
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("StructMsg", 2, "StructMsgParserHandler startElement uri = " + paramString1 + ", localName = " + paramString2 + ", qName = " + paramString3 + ", map = " + localHashMap);
    }
    paramString1 = new StructMsgNode(paramString2, localHashMap);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString2 = (StructMsgNode)this.jdField_a_of_type_JavaUtilStack.peek();
      if (paramString2 != null)
      {
        paramString1.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode = paramString2;
        paramString2.a(paramString1);
      }
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramString1);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgParserHandler
 * JD-Core Version:    0.7.0.1
 */