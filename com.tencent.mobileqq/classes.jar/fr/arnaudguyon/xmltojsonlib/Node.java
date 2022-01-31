package fr.arnaudguyon.xmltojsonlib;

import java.util.ArrayList;

class Node
{
  private ArrayList<Node.Attribute> mAttributes = new ArrayList();
  private ArrayList<Node> mChildren = new ArrayList();
  private String mContent;
  private String mName;
  private String mPath;
  
  Node(String paramString1, String paramString2)
  {
    this.mName = paramString1;
    this.mPath = paramString2;
  }
  
  void addAttribute(String paramString1, String paramString2)
  {
    this.mAttributes.add(new Node.Attribute(this, paramString1, paramString2));
  }
  
  void addChild(Node paramNode)
  {
    this.mChildren.add(paramNode);
  }
  
  ArrayList<Node.Attribute> getAttributes()
  {
    return this.mAttributes;
  }
  
  ArrayList<Node> getChildren()
  {
    return this.mChildren;
  }
  
  String getContent()
  {
    return this.mContent;
  }
  
  String getName()
  {
    return this.mName;
  }
  
  String getPath()
  {
    return this.mPath;
  }
  
  void setContent(String paramString)
  {
    this.mContent = paramString;
  }
  
  void setName(String paramString)
  {
    this.mName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     fr.arnaudguyon.xmltojsonlib.Node
 * JD-Core Version:    0.7.0.1
 */