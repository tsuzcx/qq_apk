package org.apache.commons.lang.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Enum$Entry
{
  final List list = new ArrayList(25);
  final Map map = new HashMap();
  final List unmodifiableList = Collections.unmodifiableList(this.list);
  final Map unmodifiableMap = Collections.unmodifiableMap(this.map);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.enums.Enum.Entry
 * JD-Core Version:    0.7.0.1
 */