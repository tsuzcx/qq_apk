package com.tencent.mobileqq.emosm.view;

import android.os.Environment;
import android.view.View;
import java.io.File;
import java.io.IOException;

class DragSortListView$DragSortTracker
{
  private int jdField_a_of_type_Int = 0;
  File jdField_a_of_type_JavaIoFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  public DragSortListView$DragSortTracker(DragSortListView paramDragSortListView)
  {
    if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    try
    {
      this.jdField_a_of_type_JavaIoFile.createNewFile();
      return;
    }
    catch (IOException paramDragSortListView) {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append("<DSLVStates>\n");
    this.b = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("<DSLVState>\n");
    int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildCount();
    int k = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getFirstVisiblePosition();
    this.jdField_a_of_type_JavaLangStringBuilder.append("    <Positions>");
    int i = 0;
    while (i < j)
    {
      localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append(k + i);
      localStringBuilder.append(",");
      i += 1;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("</Positions>\n");
    this.jdField_a_of_type_JavaLangStringBuilder.append("    <Tops>");
    i = 0;
    while (i < j)
    {
      localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getTop());
      localStringBuilder.append(",");
      i += 1;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("</Tops>\n");
    this.jdField_a_of_type_JavaLangStringBuilder.append("    <Bottoms>");
    i = 0;
    while (i < j)
    {
      localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getBottom());
      localStringBuilder.append(",");
      i += 1;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("</Bottoms>\n");
    StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <FirstExpPos>");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c);
    localStringBuilder.append("</FirstExpPos>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <FirstExpBlankHeight>");
    DragSortListView localDragSortListView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
    i = localDragSortListView.a(localDragSortListView.c);
    localDragSortListView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
    localStringBuilder.append(i - localDragSortListView.b(localDragSortListView.c));
    localStringBuilder.append("</FirstExpBlankHeight>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <SecondExpPos>");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d);
    localStringBuilder.append("</SecondExpPos>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <SecondExpBlankHeight>");
    localDragSortListView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
    i = localDragSortListView.a(localDragSortListView.d);
    localDragSortListView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
    localStringBuilder.append(i - localDragSortListView.b(localDragSortListView.d));
    localStringBuilder.append("</SecondExpBlankHeight>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <SrcPos>");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.e);
    localStringBuilder.append("</SrcPos>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <SrcHeight>");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.i + this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getDividerHeight());
    localStringBuilder.append("</SrcHeight>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <ViewHeight>");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeight());
    localStringBuilder.append("</ViewHeight>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <LastY>");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.l);
    localStringBuilder.append("</LastY>\n");
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append("    <FloatY>");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Int);
    localStringBuilder.append("</FloatY>\n");
    this.jdField_a_of_type_JavaLangStringBuilder.append("    <ShuffleEdges>");
    i = 0;
    while (i < j)
    {
      localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      localDragSortListView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
      localStringBuilder.append(localDragSortListView.a(k + i, localDragSortListView.getChildAt(i).getTop()));
      localStringBuilder.append(",");
      i += 1;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("</ShuffleEdges>\n");
    this.jdField_a_of_type_JavaLangStringBuilder.append("</DSLVState>\n");
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int > 1000)
    {
      c();
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:jdField_a_of_type_Boolean	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 29	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:b	I
    //   12: ifne +8 -> 20
    //   15: iconst_0
    //   16: istore_1
    //   17: goto +5 -> 22
    //   20: iconst_1
    //   21: istore_1
    //   22: new 176	java/io/FileWriter
    //   25: dup
    //   26: aload_0
    //   27: getfield 46	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   30: iload_1
    //   31: invokespecial 179	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   34: astore_2
    //   35: aload_2
    //   36: aload_0
    //   37: getfield 25	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   40: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 187	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 25	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 25	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   55: invokevirtual 190	java/lang/StringBuilder:length	()I
    //   58: invokevirtual 194	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: invokevirtual 197	java/io/FileWriter:flush	()V
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 29	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:b	I
    //   71: iconst_1
    //   72: iadd
    //   73: putfield 29	com/tencent/mobileqq/emosm/view/DragSortListView$DragSortTracker:b	I
    //   76: aload_2
    //   77: invokevirtual 200	java/io/FileWriter:close	()V
    //   80: return
    //   81: astore_3
    //   82: goto +9 -> 91
    //   85: goto +26 -> 111
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +15 -> 107
    //   95: aload_2
    //   96: invokevirtual 200	java/io/FileWriter:close	()V
    //   99: goto +8 -> 107
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   107: aload_3
    //   108: athrow
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +13 -> 125
    //   115: aload_2
    //   116: invokevirtual 200	java/io/FileWriter:close	()V
    //   119: return
    //   120: astore_2
    //   121: aload_2
    //   122: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   125: return
    //   126: astore_2
    //   127: goto -18 -> 109
    //   130: astore_3
    //   131: goto -46 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DragSortTracker
    //   16	15	1	bool	boolean
    //   34	62	2	localFileWriter	java.io.FileWriter
    //   102	2	2	localIOException1	IOException
    //   110	6	2	localObject1	Object
    //   120	2	2	localIOException2	IOException
    //   126	1	2	localIOException3	IOException
    //   81	1	3	localObject2	Object
    //   88	20	3	localObject3	Object
    //   130	1	3	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   35	76	81	finally
    //   22	35	88	finally
    //   95	99	102	java/io/IOException
    //   76	80	120	java/io/IOException
    //   115	119	120	java/io/IOException
    //   22	35	126	java/io/IOException
    //   35	76	130	java/io/IOException
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("</DSLVStates>\n");
      c();
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DragSortTracker
 * JD-Core Version:    0.7.0.1
 */