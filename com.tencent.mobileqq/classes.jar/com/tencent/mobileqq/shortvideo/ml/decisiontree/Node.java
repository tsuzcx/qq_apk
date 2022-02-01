package com.tencent.mobileqq.shortvideo.ml.decisiontree;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class Node
{
  int jdField_a_of_type_Int;
  Node jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeNode;
  List<Instance> jdField_a_of_type_JavaUtilList;
  Node[] jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode;
  int b;
  int c = -1;
  
  Node(Node paramNode, List<Instance> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeNode = paramNode;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode = new Node[Instance.jdField_a_of_type_Int];
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = ((Instance)paramList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_Int = -1;
    paramNode = new int[2];
    Node tmp57_56 = paramNode;
    tmp57_56[0] = 0;
    Node tmp61_57 = tmp57_56;
    tmp61_57[1] = 0;
    tmp61_57;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      i = ((Instance)paramList.next()).b;
      paramNode[i] += 1;
    }
    if (paramNode[0] > paramNode[1]) {}
    for (int i = 0;; i = 1)
    {
      this.c = i;
      return;
    }
  }
  
  private void a(PrintWriter paramPrintWriter)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int != -1)
    {
      paramPrintWriter.println("<branch>");
      paramPrintWriter.print("<attribute name=\"name\" value=\"");
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeNode != null) {
        break label93;
      }
      paramPrintWriter.print("root");
    }
    for (;;)
    {
      paramPrintWriter.println("\" />");
      if (this.jdField_a_of_type_Int == -1) {
        break label167;
      }
      int i = j;
      while (i < Instance.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode[i] != null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode[i].a(paramPrintWriter);
        }
        i += 1;
      }
      paramPrintWriter.println("<leaf>");
      break;
      label93:
      i = 0;
      while (i < Instance.jdField_a_of_type_Int)
      {
        if (this == this.jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeNode.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode[i]) {
          paramPrintWriter.print("fts" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeNode.jdField_a_of_type_Int + " = " + i);
        }
        i += 1;
      }
    }
    paramPrintWriter.println("</branch>");
    return;
    label167:
    paramPrintWriter.println("<attribute name=\"weight\" value=\"" + this.jdField_a_of_type_JavaUtilList.size() + "\" />");
    paramPrintWriter.println("</leaf>");
  }
  
  public int a(Instance paramInstance)
  {
    int i = -1;
    if (this.jdField_a_of_type_Int == -1) {
      i = this.c;
    }
    while (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode[paramInstance.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]] == null) {
      return i;
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode[paramInstance.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]].a(paramInstance);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new PrintWriter(new FileWriter(paramString));
      paramString.println("<?xml version=\"1.0\" ?>");
      paramString.println("<tree>");
      paramString.println("<declarations>");
      paramString.println("<attributeDecl name=\"name\" type=\"String\" />");
      paramString.println("<attributeDecl name=\"weight\" type=\"Real\" />");
      paramString.println("</declarations>");
      a(paramString);
      paramString.println("</tree>");
      paramString.close();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ml.decisiontree.Node
 * JD-Core Version:    0.7.0.1
 */