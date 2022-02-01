package com.tencent.mobileqq.mini.entry.util;

import java.io.PrintStream;
import kotlin.Metadata;
import org.junit.Test;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/entry/util/Xml2Layout;", "", "()V", "createLayout", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class Xml2Layout
{
  @Test
  public final void createLayout()
  {
    Xml2LayoutKt.xml2Layout(Xml2LayoutKt.getSourceXml());
    String str = Xml2LayoutKt.getProjectDir();
    System.out.print(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.util.Xml2Layout
 * JD-Core Version:    0.7.0.1
 */