package com.tencent.tkd.topicsdk;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/TopicItem$Page;", "", "(Ljava/lang/String;I)V", "CREATE_VIDEO", "CREATE_TOPIC", "topicsdk_release"}, k=1, mv={1, 1, 16})
public enum TopicItem$Page
{
  static
  {
    Page localPage1 = new Page("CREATE_VIDEO", 0);
    CREATE_VIDEO = localPage1;
    Page localPage2 = new Page("CREATE_TOPIC", 1);
    CREATE_TOPIC = localPage2;
    $VALUES = new Page[] { localPage1, localPage2 };
  }
  
  private TopicItem$Page() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicItem.Page
 * JD-Core Version:    0.7.0.1
 */